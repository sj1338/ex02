CREATE SEQUENCE seq_board;

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

commit;

CREATE SEQUENCE seq_comment;

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

INSERT INTO tbl_comment (cno, bno, content, writer) VALUES (seq_comment.nextval, 1, 'first comment', 'newbie');

COMMIT;

SELECT * FROM tbl_comment;