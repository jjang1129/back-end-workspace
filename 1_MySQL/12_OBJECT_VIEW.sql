/*
    뷰(VIEW) 
    - SELECT 문을 저장할 수 있는 객체 
	- 가상 테이블 (실제 데이터가 담겨있는건 x => 논리적인 테이블) 
    - DML( INSET, UPDATE, DELETE) 작업 가능 
    
    * 사용 목적
    - 편리성 : SELECT 문의 복잡도 완화 
    - 보안성 : 테이블의 특정 열을 노출하고 싶지 않은 경우 
*/
-- 한국에서 근무하는 사원들의 사번 이름 부서명 급여 근무국가명 조회 
-- 러시아에서 근무하는 사원들의 사번 이름 부서명 급여 근무국가명 조회 
--  일본 


CREATE OR REPLACE  VIEW vw_employee
AS SELECT emp_id,emp_name,dept_title,salary,national_name
			FROM employee
			JOIN department ON (dept_code = dept_id)
			JOIN location ON (location_id=local_code)
			JOIN national USING (national_code) ;





SELECT emp_id,emp_name,dept_title,salary,national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (location_id=local_code)
JOIN national USING (national_code)
WHERE national_name = '한국';


SELECT emp_id,emp_name,dept_title,salary,national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (location_id=local_code)
JOIN national USING (national_code)
WHERE national_name = '러시아';

SELECT emp_id,emp_name,dept_title,salary,national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (location_id=local_code)
JOIN national USING (national_code)
WHERE national_name = '일본';


/*
   1. VIEW 생성 
   CREATE [OR REPLACE] VIEW 뷰명 
   AS 서브쿼리 ;
   
   - OR REPLACE : 뷰 생성시 기존에 중복된 이름의 뷰가 없다면 새로 뷰 생성,
                  기존에 중복된 이름의 뷰가 있다면 해당 뷰 수정 
*/


CREATE OR REPLACE  VIEW vw_employee
AS SELECT emp_id,emp_name,dept_title,salary,national_name
			FROM employee
			JOIN department ON (dept_code = dept_id)
			JOIN location ON (location_id=local_code)
			JOIN national USING (national_code) ;


SELECT *
FROM vw_employee
WHERE national_name ='한국';


SELECT *
FROM vw_employee
WHERE national_name ='러시아';


SELECT *
FROM vw_employee
WHERE national_name ='일본';



/*
    2. 뷰 컬럼에 별칭 부여 
    - 서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어 있을 경우 반드시 별칭 지정 ! 
*/

-- 사원의 사번, 사원명, 직급명 , 성별 남/여 근무년수를 조회할 수 있는 
-- select 문을 뷰 vw_emp_job 생성 

SELECT emp_id,emp_name,job_name, if(substr(emp_no,8,1)=1,'남','여') 성별,timestampdiff(year,hire_date,current_date()) 근무년수
FROM employeevw_employee
JOIN job USING (job_code);


CREATE OR REPLACE VIEW vw_emp_job
AS   SELECT emp_id 사번 ,emp_name 사원명 ,job_name 직급명, if(substr(emp_no,8,1)=1,'남','여') 성별 ,timestampdiff(year,hire_date,current_date()) 근무년수
		FROM employee
		JOIN job USING (job_code);
        
-- 성별이 남자인 사원의 사원명과 직급명 조회         
SELECT 사원명, 직급명
FROM vw_emp_job
WHERE 성별 = '남'  ; 


-- 근무년수가 20년 이상인 사원 조회 

SELECT *
FROM vw_emp_job
WHERE 근무년수 >= 20;


/*
    3. VIEW를 이용해서 DML ( INSERT, UPDATE, DELETE) 사용 
     -뷰를 통해 조작하게되면 실제 데이터가 담겨 있는 테이블에 반영됨 
*/

CREATE OR REPLACE VIEW vw_job
AS SELECT job_code,job_name
  FROM job;
  
-- 뷰를 통해서 INSERT 가능 

INSERT INTO vw_job 
VALUES('j8','인턴');

-- 뷰를 통해서 UPDATE 가능 

UPDATE vw_job
SET job_name = '알바'
WHERE job_code = 'j8';

-- 뷰를 통해서 DELETE 가능 

DELETE FROM vw_job
WHERE job_code='j8';

SELECT *
FROM vw_job; -- 논리적인 테이블 (실제 담겨있지 x)

SELECT *
FROM job; -- 베이스 테이블 (실제 데이터가 담겨있음) 


/*
  4. DML 구문으로 VIEW 조작이 불가능한 경우 
  
*/
-- 1) 뷰 정의에 포함되지 않음 컬럼들을 조작하는 경우 

CREATE OR REPLACE VIEW vw_job
AS SELECT job_code FROM job;

-- INSERT 에러 
INSERT INTO vw_job(job_code,job_name)
VALUES ('j8','인턴');


INSERT INTO vw_job
VALUES ('j8'); -- 가능!

UPDATE vw_job
SET job_name = '인턴'
WHERE job_code = 'j8';  -- 에러 

UPDATE vw_job
SET job_code = 'j0'
WHERE job_code = 'j8'; -- 가능 !


DELETE FROM vw_job
WHERE job_name = '사원'; -- 에러 

DELETE FROM vw_job
WHERE job_code = 'j0'; -- 가능 !

-- 2) 뷰에 포함되지 않은 컬럼중에 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우 

CREATE OR REPLACE VIEW vw_job 
AS SELECT job_name
FROm job;

-- job_code가 PRIMARY KEY ! 즉 NOT NULL 제약조건에 걸림 ! 
INSERT INTO vw_job
VALUES('인턴');

UPDATE vw_job
SET job_name ='인턴'
WHERE job_name ='사원'; -- 가능 !

-- 자식 데이터가 존재하지 않는 경우만 삭제가 가능하다 !
DELETE FROM vw_job
WHERE job_name = '인턴';



-- 3. 산술 표현식 또는 함수식으로 정의된 경우 
-- 사번 , 사원명, 급여 , 연봉 (salary *12)을 조회한 SELECT 문으로 vw_emp_sal 뷰 정의 

SELECT emp_id 사번, emp_name 사원명, salary 급여,salary*12 연봉 
FROM employee;

CREATE OR REPLACE VIEW vw_emp_sal
AS  SELECT emp_id 사번 , emp_name 사원명, emp_no 주민번호, salary 급여 ,salary*12
FROM employee;

SELECT *
FROM employee;

SELECT * 
FROM vw_emp_sal;

-- 산술 연산식으로 정의된 컬럼은 데이터 추가 불가능!
INSERT INTO vw_emp_sal (사번,사원명,주민번호,급여)
VALUES (302, '홍길동','000000-0000000',3000000);

-- 산술 연삭식이 컬럼에 같이 들어가 있는 경우에 데이터 추가 불가능 
INSERT INTO vw_emp_sal (사번,사원명,주민번호,급여)
VALUES (30,'홍길동',0000000-0000000,3000000); -- 이건 나중에 확인 해주심

-- 산술연산으로 정의된 컬럼은 데이터 변경 불가능!
UPDATE vw_emp_sal
SET 연봉 = 8000000
WHERE emp_id = 200;

UPDATE vw_emp_sal
SET salary = 8000000
WHERE emp_id = 200;

UPDATE vw_emp_sal
SET 급여 = 9000000
WHERE 사번= 200; -- 산술연산과 무관한 컬럼은 데이터 변경 가능 

-- DELETE 가능 

DELETE FROM vw_emp_sal
WHERE 연봉 = 72000000;



SELECT * 
FROM vw_emp_sal;

-- 4. 그룹합수나 GROUP BY 절을 포함한 경우 
-- 부서별 급여의 합계, 평균을 조회한 SELECT 문을 vw_groupdept 뷰 정의
CREATE OR REPLACE VIEW vw_groupdept
AS SELECT dept_code,sum(salary)합계 ,format( avg(salary) ,0) 평균
				FROM employee
				GROUP BY dept_code;

SELECT *
FROM vw_groupdept;

-- INSERT 에러 
INSERT INTO vw_groupdept
VALUES ('D11',80,40);

-- UPDATE 에러 

UPDATE vw_groupdept
SET 합계 = 800
WHERE dept_code = 'D1';

-- DELETE 에러 
DELETE FROM vw_groupdept
WHERE 합계 = 52100000;


-- 5. DISTINCT 구문이 포함된 경우 
-- employee 테이블로 job_code만 중복없이 조회한 다음 SELECT 문을 vw_dt_job 뷰 정의 

SELECT DISTINCT(job_code)
FROM employee;

CREATE OR REPLACE VIEW vw_dt_job
AS  SELECT DISTINCT(job_code)
FROM employee;

SELECT *
FROM vw_dt_job;


-- INSERT 에러 
INSERT INTO vw_dt_job
VALUES('j8');

-- UPDATE 에러 

UPDATE vw_dt_job
SET jobe_code ='j0'
WHERE jobe_code ='j1';

-- DELETE 에러 
DELETE FROM vw_dt_job
WHERE job_code = 'j2' ;



SELECT dept_code,sum(salary) 합계 , avg(salary) 평균 
FROM employee
GROUP BY dept_code;


-- 6. JOIN을 이용해서 여러 테이블을 연결한 경우 

-- 사원들의 사번, 사원명, 주민번호, 부서명 조회한 SELECT 문을 vw_joinemp 뷰 정의 





CREATE OR REPLACE VIEW vw_joinemp
AS	SELECT emp_id,emp_name,emp_no,dept_title
	FROM employee
	JOIN department ON ( dept_code = dept_id);

-- INSERT 

INSERT INTO vw_joinemp
VALUES (500,'송준호','800000-1234567','총무부');


INSERT INTO vw_joinemp (emp_id,emp_name,emp_no)
VALUES (500,'송준호','800000-1234567'); -- 가능 ! 

-- update
UPDATE vw_joinemp
SET emp_name='박성철'
WHERE emp_id=214;


UPDATE vw_joinemp
SET dept_title='회계부'
WHERE emp_id=214;


-- DELETE 에러 

DELETE FROM vw_jobemp
WHERE emp_id = 214;

SELECT *
FROM vw_joinemp;


-- 7. VIEW 옵션

-- WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 에러 발생! 
-- 급여가 3000000원 이상인 사원들만 조회한 SELECT 문을 vw_emp 뷰 정의 

CREATE OR REPLACE VIEW vw_emp
AS 		SELECT *
		FROM employee
		WHERE salary >= 3000000;
        
-- 200번 사원의 급여를 200만원으로 변경 (vw_emp 이용해서)

UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 205;


-- WITH CHECK OPTION 사용 ! 
CREATE OR REPLACE VIEW vw_emp
AS 		SELECT *
		FROM employee
		WHERE salary >= 3000000
WITH CHECK OPTION;

-- 202번 사원의 급여를 200만원으로 변경 vw emp 이용해서 

UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 202; -- 에러 발생 !

-- 202번 사원의 급여를 400만원으로 변경 vw emp 이용해서 

UPDATE vw_emp
SET salary = 4000000
WHERE emp_id = 202;








SELECT *
FROM vw_emp;































