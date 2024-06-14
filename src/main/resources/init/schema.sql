drop table if exists employee;
drop table if exists department;
drop table if exists position;
drop table if exists salary;
drop table if exists evaluation;
drop table if exists vacation;
drop table if exists attendance;

create table employee(
    ueid char(4) primary key comment '직원 고유 식별자',
    employee_id char(12) unique comment '사원 번호',
    password char(80) not null comment '비밀번호',
    name char(37) not null comment '이름',
    gender char(1) not null comment '성별',
    birth char(8) not null comment '생년월일',
    personal_phone_number char(11) comment '개인 전화번호',
    external_tell_number char(11) comment '사내 외부번호',
    internal_tell_number char(11) comment '사내 내선번호',
    personal_email_address char(50) comment '개인 이메일 주소',
    company_email_address char(50) comment '사내 이메일 주소',
    department_code char(2) comment '부서',
    position_code char(2) comment '직급',
    join_date char(8) comment '입사일',
    resign_date char(8) comment '퇴사일',
    employment_type char(1) comment '근무 유형',
    remaining_days int default 0 not null comment '남은 연차',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자'
);

create table department(
    department_code char(2) primary key comment '부서 코드',
    department_name char(15) not null comment '부서명',
    parent_department_code char(2) comment '상위 부서 코드',
    department_manager_ueid char(4) comment '부서장 고유 식별자',
    foundation_date char(8) not null comment '설립일',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자'
);

create table position(
    position_code char(2) primary key comment '직급 코드',
    position_name char(15) not null comment '직급명',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자'
);

create table salary(
    ueid char(4) primary key comment '직원 고유 식별자',
    salary_type char(1) not null comment '지급 유형',
    payment_date char(2) not null comment '지급일',
    base_salary int comment '기본급',
    performance_bonus int comment '성과급',
    special_bonus int comment '특수급',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자'
);

create table evaluation(
    ueid char(4) comment '직원 고유 식별자',
    seq int auto_increment comment '순번',
    evaluation_start_date char(8) not null comment '성과 평가 시작 날짜',
    evaluation_end_date char(8) comment '성과 평가 종료 날짜',
    evaluation_item text comment '성과 평가 항목',
    evaluation_result text comment '성과 평가 결과',
    evaluation_comment text comment '성과 평가 비고',
    evaluation_responsibility char(4) not null comment '성과 평가자',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자',
    constraint evaluation_pk primary key(ueid, seq)
);

create table vacation(
    ueid char(4) comment '직원 고유 식별자',
    seq int auto_increment comment '순번',
    vacation_type char(1) comment '휴가 종류',
    start_date char(8) comment '시작 날짜',
    end_date char(8) comment '종료 날짜',
    using_days int comment '사용 일수',
    remaining_days int comment '잔여 일수',
    vacation_purpose text comment '휴가 목적',
    approval_responsibility char(4) comment '승인자',
    vacation_request_date char(8) comment '휴가 신청 날짜',
    vacation_approval_date char(8) comment '휴가 승인 날짜',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자',
    constraint vacation_pk primary key(ueid, seq)
);

create table attendance(
    ueid char(4) comment '직원 고유 식별자',
    attendance_date char(8) comment '날짜',
    attendance_day char(1) not null comment '요일',
    arrival_time char(6) not null comment '출근 시각',
    departure_time char(6) not null comment '퇴근 시각',
    remarks text comment '비고',
    insert_at char(14) not null comment '생성일',
    insert_by char(4) not null comment '생성자',
    update_at char(14) comment '수정일',
    update_by char(4) comment '수정자',
    constraint attendance_pk primary key(ueid, attendance_date)
);
