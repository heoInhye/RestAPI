Restful API
===

+ HTTP/WEB API가 아닌 REST 아키텍처 스타일을 준수하는 REST API 구현
+ self-descrive message와 HATEOAS에 대한 해결방법 제시
+ 백기선님의 스프링 기반 REST API 개발 강의 참고(https://www.inflearn.com/course/spring_rest-api/dashboard)
---

### REST 아키텍처 스타일
* Client-Server /br
* Stateless
* Cache
* Uniform Interface
  * self-descrive message
    * 메시지에 대한 설명이 스스로 가능
    * 확장 가능
  * hypermedia as the engine of appliaction state (HATEOAS)
    * 링크를 통해 상태변화 가능
    * 링크정보를 동적으로 변경 가능(Versioning 불필요)
* Layered System
* Code-On-Demand (optional)

### self-descrive message 해결방법
1. Media type을 정의하여 IANA에 등록한다. resource를 리턴할 때 등록한 Media Type을 Content-type으로 사용한다.
2. profile 링크 헤더를 추가한다. 하지만 브라우저들이 지원을 하지 않는 경우가 많다. 따라서 HAL의 링크 데이터에 profile 링크를 추가한다.

### HATEOAS 해결방법
1. 데이터에 링크를 제공한다. (HAL로 링크를 정의)
2. 링크 헤더나 Location을 제공한다.
