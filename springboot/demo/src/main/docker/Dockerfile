# 使用官方的 OpenJDK 11 镜像作为基础镜像
FROM openjdk:11-jre-slim
# 设置工作目录
WORKDIR /app
# 复制应用程序的 JAR 文件到容器中
COPY demo-1.0.jar /app/

# 暴露应用程序的端口（如果有需要）
EXPOSE 8080

# 指定容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "demo-1.0.jar"]
