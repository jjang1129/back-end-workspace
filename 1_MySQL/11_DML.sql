/*
   DML (Data Manipulation Language)
   - 데이터 조작 언어로 테이블에 값을 삽입(INSERT) 하거나,
      수정(UPDATE)하거나, 삭제(DELETE) 하는 구문 
  
   INSERT 
   - 테이블에 새로운 행을 추가하는 구문 
   
   1) INSERT INTO 테이블명 VALUES (값,값,값,...);
    - 테이블에 모든 컬럼에 대한 값을 INSERT 하고자 할 때 사용한다
    - 컬럼 순번을 지켜서 VALUES 값을 나열해야 한다.
    
   2) (INSERT INTO 테이블명컬럼명,컬럼명,..) VALUES (값,값,값..);
    - 테이블의 특정 컬럼에 대한 값만 INSERT 할떄 사용 
    - 선택이 안된 컬럼들은 기본적으로 NULL값이 들어간다. 
      그러나 NOT NULL 조건이 걸려있는 컬럼들은 반드시 값을 입력해야한다 
	- 기본값 (DEFAULT)이 지정되어 있으면 NULL이 아닌 기본값이 들어간다.
    
    3) INSERT INTO 테이블명 서브쿼리;
    - VALUES 대신 서브쿼리 조회한 결과값이 통째로 INSERT 된다 
    - 서브쿼리 결과값이 INSERT문에 지정된 테이블의 컬럼 개수와 같아야 한다.
*/

-- 사용할 테이블 생성 ----------------------------------------------------------------

CREATE TABLE emp(
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(30) NOT NULL,
    dept_title VARCHAR(30) DEFAULT '개발팀',
    hire_date DATE DEFAULT (current_date)  
);

-- 1) 
INSERT INTO emp 
VALUES (1,'윤대훈','서비스 개발팀',default);

-- 모든 컬럼값을 지정하지 않아서 에러!
INSERT INTO emp
VALUES ('이동엽','개발 지원팀',default);

-- 데이터 타입이 맞지 않아서 에러 !
INSERT INTO emp
VALUES ('개발 지원팀', 3,'이동엽',default);

INSERT INTO emp 
VALUES ('200', '김밥' , '개발홍보팀',default); 

SELECT * 
FROM emp;


-- 2) 원하는 컬럼만 입력

INSERT INTO emp (emp_id,emp_name,dept_title,hire_date)
VALUES (3,'이준용','보안팀',null);

INSERT INTO emp( emp_name)
VALUES ('윤유진');

INSERT INTO emp(dept_title,emp_name)
VALUES ('인사팀','유영민') ;

INSERT INTO emp(emp_id,emp_name)
VALUES (201,'김밥1');

-- emp_name 칼럼에 not null 제약조건으로 인한 에러!
INSERT INTO emp(dept_title)
VALUES ('마케팅팀');

-- 3) 서브쿼리 이용 

-- kh.employee 에서 사번 이름 부서명 입사일 가져오기 

INSERT INTO EMP
SELECT emp_id,emp_name,dept_title,hire_date 
FROM kh.employee
JOIN kh.department ON (dept_code = dept_id);

-- 컬럼명을 명시 
INSERT INTO emp(dept_title,emp_name,hire_date)
SELECT dept_title,emp_name,hire_date
FROM kh.employee
JOIN kh.department ON (dept_code = dept_id);


-- 테이블 구조만 복사 !

CREATE TABLE emp_dept
SELECT emp_id,emp_name,dept_code,hire_date
FROM kh.employee
WHERE 1=0;

CREATE TABLE emp_manager
SELECT emp_id,emp_name,manager_id
FROM kh.employee
WHERE 1 = 0;


SELECT * FROM emp_dept;
SELECT * FROM emp_manager;

-- emp_dept 테이블에 employee에서 부서 코드가 D1인 직원의 사번 이름 부서코드 입사일 추가 
-- emp_manager 테이블에 employee에서 부서코드가 D1인 직원의 사번,이름 , 관리자 사번 추가 


INSERT INTO emp_dept
SELECT emp_id,emp_name,dept_code,hire_date 
FROM kh.employee
WHERE dept_code= 'D1';


INSERT INTO emp_manager
SELECT emp_id,emp_name,manager_id
FROM kh.employee
WHERE dept_code='D1';

/*
    UPDATE 
    - 테이블에 기록된 데이터를 수정하는 구문 
    
    UPDATE 테이블명
    SET 컬럼명 = 변경하려는값, 
        컬럼명 = 변경하려는값,....
	WHERE 조건 ;
    
    -SET 절에서 여러 개의 컬럼을 콤마로 나열해서 값을 동시에 변경할 수 있다
    -WHERE 절을 생략하면 모든 행의 데이터가 변경된다. (MY SQL 방지)
    - 사실 서브쿼리 사용 가능 ! 잘 쓰이지도 않고 버전마다 상황이 다름 .
    
*/

SELECT * FROM dept_copy;
SELECT * FROM emp_salary ;



-- emp salary 에서 이태림 사원의 급여를 3000000원으로 , 보너스를 0.4로 변경 

UPDATE emp_salary 
SET salary = 3000000,
    bonus = 0.4 
    WHERE emp_name = '이태림';
    
-- 모든 사원의 급여를 기존급여에서 10프로 인상한 급여로 변경하시오 

UPDATE emp_salary 
SET salary= salary*1.1;

UPDATE emp_salary
SET salary= salary*1.2	
WHERE salary > 500000;

-- 사번이 201인 사원의 사원번호를 NULL로 변경 

UPDATE emp_salary
SET emp_id = null
WHERE emp_id = 201;
-- >> emp_id PRIMARY KEY 제약 조건 위배 


-- 아시아 지역에 근무하는 직원들의 보너스를 0.3으로 변경 
SELECT * FROM kh.employee;
SELECT * FROM kh.department;
SELECT * FROM kh.location;
SELECT * FROM emp_salary;



SELECT emp_name
FROM kh.department
JOIN kh.employee ON (dept_id = dept_code)
JOIN kh.location ON( location_id = local_code)
WHERE local_name LIKE 'ASIA%';



UPDATE emp_salary 
SET bonus = 0.3
WHERE emp_name IN (SELECT emp_name
					FROM kh.department
					JOIN kh.employee ON (dept_id = dept_code)
					JOIN kh.location ON( location_id = local_code)
					WHERE local_name LIKE '%ASIA%');


/*
    DELETE 
    - 테이블에 기록된 데이터를 삭제하는 구문 
    
    DELETE FROM 테이블명 
    WHERE 조건식;
    
    -WHERE 절을 제시하지 않으면 전체 행이 삭제된다 
 
*/

-- emp_salary 에서 dept_code가 D5인 직원들 삭제

DELETE FROM emp_salary 
WHERE dept_code = 'D5';

SELECT *
FROM employee;
 /*
    TRUNCATE 
    - 테이블 전체 행을 삭제할 때 사용하는 구문
    - DELETE 보다 속도 빠름
    - 별도의 조건 제시 불가 ROLLBACK도 불가 
    
    TRUNCATE TABLE 테이블명 ;
 
 */

START transaction;

DELETE FROM emp_salary; 
DELETE FROM dept_copy;


ROLLBACK;  -- DELETE는 ROLLBACK 가능 ! 

TRUNCATE TABLE emp_salary;
TRUNCATE TABLE dept_copy;

ROLLBACK; -- TRUNCATE 는 ROLLBACK 불가능 !

Select *
FROM emp_salary ;
SELECT *
FROM dept_copy;


