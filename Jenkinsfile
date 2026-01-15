pipeline {
    // 指定Jenkins执行该Pipeline的代理节点（any表示任意可用节点）
    agent any

    tools {
        maven 'Maven 3.9.5' // 替换为你在Jenkins中配置的Maven名称
        jdk 'JDK 17'
    }
    // 定义构建过程中需要的环境变量
    environment {
        // GitHub仓库地址（替换为你的项目地址）
        GITHUB_REPO_URL = 'https://github.com/wenjhaang/test.git'
        // 项目构建后的输出目录（根据实际项目调整）
        BUILD_OUTPUT_DIR = 'target'
        // 部署目标服务器信息（示例，根据实际部署方式调整）
        DEPLOY_SERVER = '121.41.188.31'
        DEPLOY_PATH = '/opt/app/test-project'
    }

    // 定义构建阶段
    stages {
        // 阶段1：拉取GitHub代码
        stage('Checkout Code') {
            steps {
                echo '开始从GitHub拉取代码...'
                // 使用git插件拉取代码，branch可根据需要改为main/dev等
                git url: env.GITHUB_REPO_URL, branch: 'main', credentialsId: 'github-credentials'
            }
        }

        // 阶段2：构建项目（以Maven为例，前端项目可替换为npm run build）
        stage('Build Project') {
            steps {
                echo '开始构建项目...'
                // 执行Maven构建（跳过测试可加 -DskipTests）
                sh '''
                    chmod +x mvnw
                    ./mvnw clean package -Dmaven.test.skip=true
                '''

                // 验证构建产物是否存在
                sh "test -f ${env.BUILD_OUTPUT_DIR}/*.jar || { echo '构建失败，未生成jar包'; exit 1; }"
            }
            post {
                // 构建失败时发送通知（可选）
                failure {
                    echo '构建阶段失败！'
                }
            }
        }

        // 阶段3：测试项目（可选，根据需要开启）
        stage('Test Project') {
            steps {
                echo '开始执行单元测试...'
                sh 'mvn test'
            }
        }

        // 阶段4：部署项目（以远程服务器部署为例）
        stage('Deploy Project') {
            steps {
                echo '开始部署项目到服务器...'
                // 示例：通过scp将构建产物上传到目标服务器（需配置Jenkins节点免密登录）
                sh """
                    # 创建部署目录
                    ssh root@${env.DEPLOY_SERVER} "mkdir -p ${env.DEPLOY_PATH}"
                    # 上传jar包到目标服务器
                    scp ${env.BUILD_OUTPUT_DIR}/*.jar root@${env.DEPLOY_SERVER}:${env.DEPLOY_PATH}/
                    # 重启应用（示例，根据实际项目调整）
                    ssh root@${env.DEPLOY_SERVER} 'ps -ef | grep -E "java.*" | grep -v grep | awk "{print \\\$2}" | xargs -r kill -9'
                    ssh root@${env.DEPLOY_SERVER} "nohup java -jar ${env.DEPLOY_PATH}/*.jar > ${env.DEPLOY_PATH}/app.log 2>&1 &"
                """
            }
        }
    }

    // 构建完成后的后置操作
    post {
        success {
            echo 'Pipeline执行成功！项目已部署完成。'
        }
        failure {
            echo 'Pipeline执行失败！请检查日志排查问题。'
            // 可选：发送邮件/钉钉通知
            // emailext to: 'your-email@example.com', subject: 'Jenkins构建失败', body: '构建失败，请及时处理'
        }
        always {
            echo 'Pipeline执行结束，清理临时文件...'
            // 清理构建临时文件
            sh 'mvn clean'
        }
    }
}