FROM jenkins/jenkins:2.289.3-jdk11

USER root

RUN apt-get update \
 && apt-get -y install lsb-release \
 && curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg \
 && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null \
 && apt-get update \
 && apt-get -y install docker-ce docker-ce-cli containerd.io \
 && apt-get update -qq \
 && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common \
 && curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - \
 && add-apt-repository \
    "deb [arch=amd64] https://download.docker.com/linux/debian \
    $(lsb_release -cs) \
    stable" \
 && apt-get update  -qq \
 && apt-get -y install docker-ce \
 && usermod -aG docker jenkins

# 호스트 시스템의 사용자 ID와 그룹 ID를 ARG로 받아서 사용합니다.
ARG HOST_USER_ID
ARG HOST_DOCKER_GROUP_ID

# 호스트 사용자의 ID를 Jenkins 사용자의 ID로 변경합니다.
RUN usermod -u ${HOST_USER_ID} jenkins && \
    # 호스트의 도커 그룹 ID를 도커 그룹의 ID로 변경하고 Jenkins 사용자를 해당 그룹에 추가합니다.
    groupmod -g ${HOST_DOCKER_GROUP_ID} docker && \
    usermod -aG docker jenkins

USER jenkins
