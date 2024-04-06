ARG JAVA_VERSION

FROM openjdk:${JAVA_VERSION}


ARG USERNAME
ARG USER_UID
ARG USER_GID=${USER_UID}
ARG LANG

ARG MAVEN_VERSION
ARG MAVEN_HOME

# ARG TOMCAT_VERSION
# ARG CATALINA_HOME

# ARG GRADLE_VERSION
# ARG GRADLE_HOME

ENV LANG=${LANG}
ENV MAVEN_CONFIG /home/${USERNAME}/.m2

# ENV HTTP_PROXY=http://host.docker.internal:7890
# ENV HTTPS_PROXY=http://host.docker.internal:7890
# ENV NO_PROXY=localhost,127.0.0.1

COPY ohmyzsh.sh /tmp/

# Configure apt
# 更新包列表并安装基础工具
RUN apt-get update \
    && apt-get -y install --no-install-recommends apt-utils dialog zsh 2>&1 \
    && apt-get install -y git openssh-client less iproute2 procps curl lsb-release unzip vim jq sudo \
    && apt-get autoremove -y \
    && apt-get clean -y \
    && rm -rf /var/lib/apt/lists/*

# 创建非root用户
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd -s /bin/zsh --uid $USER_UID --gid $USER_GID -m $USERNAME

# 配置sudo免密码
RUN echo "${USERNAME} ALL=(root) NOPASSWD:ALL" > /etc/sudoers.d/${USERNAME} \
    && chmod 0440 /etc/sudoers.d/${USERNAME}

# 用户目录中添加bin目录
RUN sudo -u ${USERNAME} mkdir /home/${USERNAME}/bin

# 安装Maven
RUN mkdir -p ${MAVEN_HOME} \
    && curl -fsSL -o /tmp/apache-maven.tar.gz https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    # && echo "${MAVEN_SHA} /tmp/apache-maven.tar.gz" | sha512sum -c - \
    && tar -xzf /tmp/apache-maven.tar.gz -C ${MAVEN_HOME} --strip-components=1 \
    && rm -f /tmp/apache-maven.tar.gz \
    && ln -s ${MAVEN_HOME}/bin/mvn /home/${USERNAME}/bin/mvn

# 设置环境变量
RUN echo "export JAVA_HOME=${JAVA_HOME}" >> /home/${USERNAME}/.envrc \
    && echo "export MAVEN_HOME=${MAVEN_HOME}" >> /home/${USERNAME}/.envrc \
    && echo "export PATH=/home/${USERNAME}/bin:\$PATH" >> /home/${USERNAME}/.envrc

# 设置.zshrc
RUN sudo -u ${USERNAME} touch /home/${USERNAME}/.zshrc \
    && echo ". ~/.envrc" > /home/${USERNAME}/.zshrc

# 安装oh-my-zsh (如果有需要)
RUN chmod +x /tmp/ohmyzsh.sh

# Clean up
RUN apt-get autoremove -y \
    && apt-get clean -y \
    && rm -rf /var/lib/apt/lists/*