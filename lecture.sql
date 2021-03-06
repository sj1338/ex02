CREATE SEQUENCE seq_board;
DROP SEQUENCE seq_board;

CREATE TABLE tbl_board (
    bno NUMBER(10, 0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    updatedate DATE DEFAULT SYSDATE
    );

ALTER TABLE tbl_board ADD CONSTRAINT pk_board
PRIMARY KEY (bno);

INSERT INTO tbl_board (bno, title, content, writer)
VALUES (seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

DROP TABLE tbl_board;

commit;

CREATE SEQUENCE seq_comment;
DROP SEQUENCE seq_comment;

CREATE TABLE tbl_comment (
    cno NUMBER(10, 0), 
    bno NUMBER(10, 0),
    content VARCHAR2(500) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    PRIMARY KEY(cno)
);

ALTER TABLE tbl_comment ADD updatedate DATE DEFAULT SYSDATE;

DROP TABLE tbl_comment;

INSERT INTO tbl_comment (cno, bno, content, writer) VALUES (seq_comment.nextval, 130, 'first comment', 'newbie');

COMMIT;

SELECT * FROM tbl_comment;
SELECT * FROM tbl_board;


SELECT bno, title, content, writer, regdate, updatedate FROM
(SELECT ROW_NUMBER() OVER (ORDER BY bno DESC) rn, bno, title, content, writer, regdate, updatedate FROM tbl_board)
WHERE rn BETWEEN ? and ?;


상품 이럼, 번호ㅡ 이미지 경로


CREATE TABLE tbl_reply (
    rno NUMBER(10, 0),
    bno NUMBER(10, 0) NOT NULL,
    reply VARCHAR2(1000) NOT NULL,
    replyer VARCHAR2(50) NOT NULL,
    replyDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
    );

CREATE SEQUENCE seq_reply;

ALTER TABLE tbl_reply ADD CONSTRAINT pk_reply PRIMARY KEY(rno);

ALTER TABLE tbl_reply ADD CONSTRAINT fk_reply_board FOREIGN KEY (bno) REFERENCES tbl_board(bno);



SELECT * FROM tbl_board ORDER BY bno DESC;
SELECT * FROM tbl_reply ORDER BY bno DESC; 

delete from tbl_reply where rno = 61;

commit;






























