# applicant-estate

- 부동산 관련 JSON 형태의 RAW DATA를 무작위로 읽고 파싱, 가공하여 응답합니다 

# 스택

- Java 17
- Springboot 3.4

# 구동

> 아래와 같은 사항이 설치되어 있어야 합니다
>
> - Docker
> - openjdk
> - Gradle 7

- 프로젝트 디렉토리에서 다음 명령어를 실행해주세요 `bash deploy.sh`

# 확인

> http://localhost:9090/parse

- 해당 URL로 `GET` 요청하여 결과를 확인해주세요
- 매 요청마다 다른 데이터를 파싱, 가공하여 응답합니다 

