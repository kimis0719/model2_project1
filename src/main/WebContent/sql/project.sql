-- 테이블 작성

-- 회원가입 테이블
CREATE TABLE MEMBER(
     MEM_NUM NUMBER NOT NULL PRIMARY KEY  -- 회원번호
    ,MEM_ID VARCHAR2(10) NOT NULL  -- 회원 아이디
    ,MEM_NICK VARCHAR2(40) NOT NULL  -- 회원 닉네임
    ,MEM_PASS VARCHAR2(20) NOT NULL  -- 비밀번호
    ,MEM_EMAIL VARCHAR2(50)  -- 이메일
    ,MEM_DATE DATE  -- 가입일자
    ,MEM_IMG VARCHAR2(4000)  --  회원 사진
    ,MEM_PHONE NUMBER  --  핸드폰 번호
    ,MEM_UP_MEMNUM NUMBER  -- 수정자
    ,MEM_UP_DATE DATE  -- 수정일
    ,MEM_YN VARCHAR2(3) -- Y/N
    ,MEM_GRADE NUMBER  -- 회워 등급
);
-- 회원가입 로그 테이블
CREATE TABLE MEM_HIST(
     MEM_HIST_DATE DATE  -- 수정일자(로그용)      
    ,MEM_NUM NUMBER NOT NULL  -- 회원 번호
    ,MEM_ID VARCHAR2(10) NOT NULL  -- 회원 아이디
    ,MEM_NICK VARCHAR2(40) NOT NULL  -- 회원 닉네임
    ,MEM_PASS VARCHAR2(20) NOT NULL  -- 비밀번호
    ,MEM_EMAIL VARCHAR2(50)  -- 이메일
    ,MEM_DATE DATE  -- 가입일자
    ,MEM_IMG VARCHAR2(4000)  -- 회원 사진
    ,MEM_PHONE NUMBER  -- 핸드폰 번호
    ,MEM_UP_MEMNUM NUMBER  -- 수정자
    ,MEM_UP_DATE DATE  -- 수정일
    ,MEM_YN VARCHAR2(3)  -- Y/N
    ,MEM_GRADE NUMBER  -- 회원 등급
    ,MEM_TRI_TAG VARCHAR2(1)  -- 구분기호(U or D)
);
-- 게시판 테이블
CREATE TABLE BOARD(
     BOARD_NUM NUMBER NOT NULL PRIMARY KEY  -- 게시글 번호 
    ,BOARD_TITLE VARCHAR2(200) NOT NULL  -- 게시글 제목
    ,BOARD_CONTENT VARCHAR2(4000) NOT NULL  -- 게시글 내용
    ,BOARD_MEMNUM NUMBER NOT NULL  -- 작성자 회원번호
    ,BOARD_MEMNICK VARCHAR2(40) NOT NULL  -- 작성자 닉네임
    ,BOARD_DATE DATE  -- 작성일
    ,BOARD_COUNT NUMBER  --조회수
    ,BOARD_GOOD NUMBER  -- 좋아요
    ,BOARD_BAD NUMBER  -- 싫어요
    ,BOARD_UP_MEMNUM NUMBER  -- 수정자
    ,BOARD_UP_DATE DATE  -- 수정일
    ,BOARD_YN VARCHAR2(3)  -- Y/N
    ,CATE_NUM NUMBER REFERENCES CATEGORY(CATE_NUM)  -- 카테고리
);

-- 게시판 로그 테이블
CREATE TABLE BOARD_HIST(
     BOARD_HIST_DATE DATE  -- 수정일자(로그용)
    ,BOARD_NUM NUMBER NOT NULL  -- 게시글 번호
    ,BOARD_TITLE VARCHAR2(200) NOT NULL  -- 게시글 제목
    ,BOARD_CONTENT VARCHAR2(4000) NOT NULL  -- 게시글 내용
    ,BOARD_MEMNUM NUMBER NOT NULL  -- 작성자 회원 번호
    ,BOARD_MEMNICK VARCHAR2(40) NOT NULL  -- 작성자 닉네임
    ,BOARD_DATE DATE  -- 작성일
    ,BOARD_COUNT NUMBER  -- 조회수
    ,BOARD_GOOD NUMBER  -- 좋아요
    ,BOARD_BAD NUMBER  -- 싫어요
    ,BOARD_UP_MEMNUM NUMBER  -- 수정자
    ,BOARD_UP_DATE DATE  -- 수정일
    ,BOARD_YN VARCHAR2(3)  -- Y/N
    ,BOARD_CATENUM NUMBER  -- 카테고리
    ,BOARD_TRI_TAG VARCHAR2(1)  -- 구분 기호(U or D)
);

-- 즐겨찾기(스크랩) 테이블
CREATE TABLE SCRAP(
     SC_NUM NUMBER NOT NULL  -- 글번호
    ,SC_NICK VARCHAR2(40) NOT NULL  -- 작성자 닉네임
    ,SC_TITLE VARCHAR2(200) NOT NULL  -- 글제목
    ,SC_DATE DATE NOT NULL  -- 즐겨찾기한 날짜
    ,SC_MEMNUM NUMBER NOT NULL  --사용자 회원번호
    ,SC_YN VARCHAR2(3)  -- Y/N
);

-- 문의사항 테이블
CREATE TABLE QNA(
     QNA_NUM NUMBER NOT NULL PRIMARY KEY  -- 문의글 번호
    ,QNA_MEMNUM NUMBER NOT NULL  -- 회원번호
    ,QNA_WRITER NUMBER NOT NULL  -- 작성자
    ,QNA_DATE DATE NOT NULL  -- 작성일
    ,QNA_TITLE VARCHAR2(200) NOT NULL  -- 문의 제목
    ,QNA_CONTENT VARCHAR2(4000) NOT NULL  -- 문의 내용
    ,QNA_KIND VARCHAR2(200) NOT NULL  -- 문의글 종류
    ,QNA_SEC NUMBER  -- 비밀글 여부
    ,QNA_STEP NUMBER  -- 문의글 출력순서
    ,QNA_DEPTH NUMBER  -- 글 깊이
    ,QNA_REF NUMBER  -- 문의글 그룹번호
    ,QNA_YN VARCHAR2(3)  -- Y/N
    ,QNA_CHECK NUMBER  -- 답변 여부
);

-- 게시판 카테고리 테이블
CREATE TABLE CATEGORY(
      CATE_NUM NUMBER NOT NULL PRIMARY KEY  -- 카테고리 번호
     ,CATE_CODE NUMBER NOT NULL  -- 카테고리 분류
     ,CATE_NAME VARCHAR2(50) NOT NULL  -- 게시판 명
);

-- 게시판 파일 테이블
CREATE TABLE BOARDFILE(
      FILE_NUM NUMBER NOT NULL PRIMARY KEY  -- 파일 번호
     ,FILE_ONAME VARCHAR2(4000) NOT NULL  -- FILE_ONAME
     ,FILE_FNAME VARCHAR2(4000) NOT NULL  -- FILE_FNAME
     ,FILE_YN VARCHAR2(3)  -- Y/N
     ,BOARD_NUM NUMBER REFERENCES BOARD(BOARD_NUM)  -- 게시글 번호
);

-- 댓글 테이블
CREATE TABLE REPLY(
     RE_NUM NUMBER NOT NULL PRIMARY KEY  -- 댓글 번호
    ,RE_WRITER VARCHAR2(40) NOT NULL  -- 댓글 작성자
    ,RE_DATE DATE NOT NULL  -- 댓글 작성일
    ,RE_SEQ NUMBER  -- 댓글 출력순서
    ,RE_LEVEL NUMBER  -- 댓글 깊이
    ,RE_REF NUMBER  -- 댓글 그룹 번호
    ,RE_YN VARCHAR2(3)  -- Y/N
    ,BOARD_NUM NUMBER REFERENCES BOARD(BOARD_NUM)  -- 게시글 번호
);