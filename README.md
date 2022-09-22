 # 💰Coin Pocket Application
회사들의 주식정보를 보고 자신의 입출금 내용을 기록하고 확인할 수 있는 앱입니다.

# 👏  Application tip
1. 달력에 있는 날짜마다 본인이 기록할 내용을 저장할 수 있습니다.
2. 왼쪽 위에 아이콘을 선택하여 한달씩 분석한 수입과 출금을 확인할 수 있습니다.
3. 본인이 관리한 돈을 확인하며 회사목록에서 회사들의 주식정보를 보며 투자 할지 생각 할 수 있습니다(구현중)
# 💡 Stack &amp; Libraries
* Kotlin 베이스
* Coroutines,flow: 비동기 작업으로 작업속도를 줄이기 위해 사용하였습니다.
* Jetpack 
   * Compose :UI 구축을 위한 최신 개발환경으로 xml과 연동하지 않아 코드도 절약하고 연동시 오류도 적어지기 때문에 사용하였습니다
   * View Model:UI 관련 데이터 홀더,실행을 위한 비동기 작업을 쉽게 예약하고 관리합니다.
* Dagger-Hilt(DI): 클래스들 간에 결합 도를 낮춰 코드의 재사용성을 늘리기 위해서 사용하였다
* Retrofit2(REST APIs): 서버-클라이언트 통신을 편하게 하려고 사용하였습니다.
* OkHttp3 :인터셉터를 사용하여 서버에서 받은 내용을 확인하기 위해서 사용하였습니다.
* Room-database: 스마트폰 내장 DB에 데이터를 저장하기 위해 사용하였습니다.
* Clean Architecture:탐색할 파일을 쉽게 찾을 수 있고 파일 간 역할을 확실히 하여 수정하기도 쉬워 유지 보수하기 편리하고 스스로 개발하는 순서와 코드를 정리하기 좋아서 사용하였습니다.
* MVVM:Model,View,ViewModel간에 의존성을 없애 복잡도를 줄이고 유지보수에 용이하여서 사용하였습니다
* Kotlinx-serialization:Room에 primitive type가 아닌 data Class를 저장하기 위해서 String으로 변환하여 저장하기 위해서 사용하였습니다.
* Open source library
    * Compose Calendar:open source library를 경험하고 Calendar를 편리하게 받아와서 제작된 코드들을 수정하고 참고하며 공부하기 위해서 사용하였습니다.
  * Compose-Destination:Navigation사용시 필요한 인수들을 자동으로 생성하고 NavGraph등을 관리해주는 라이브러리라 사용하였습니다.

