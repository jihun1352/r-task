# r-task

// 개발 환경 </br>
Spring boot 2.3.10, Maven, Hibernate/JPA ,Java11, jsp, H2, BootStrap-3.3.7 </br>

// 접속 방법	</br>
웹페이지    : http://localhost:8080  </br>
h2 웹 콘솔 : http://localhost:8080/h2	</br>

// 첨부파일 경로 </br>
프로젝트 경로인 /r-task/upload/     </br>

회원가입/로그인 기능 </br>
로그인시 세션에 user_id 값을 담는다.

사용자 패스워드 암호화 </br>
: PasswordEncoder 인터페이스의 BcryptPasswordEncoder 클래스를 사용하여 암호화 </br>

서버 재기동시 세션 초기화</br>
: server.servlet.session.persistent=false	</br>


// history </br>
로그아웃 상태에서 write로 접속했을때 글쓰기하면 튕기도록 설정하기   </br>
regId도 baseEntity에 넣어보기 추가로 세션 관리 jpa방식으로


// 기재 사항 </br>
중복 로그인 가능입니다 막아놓지 않음</br>
페이징 처리 진행중 </br>

// 프로그램 설명 </br>
게시글 목록 및 상세 조회는 로그인 없이도 가능
글 작성, 수정, 삭제는 로그인 후 이용 가능
게시글 목록은 한 페이지에 5개의 데이터가 보여지도록 설정



ps. 개인적으로 JPA를 공부하면서 과제 진행을 하였습니다.

