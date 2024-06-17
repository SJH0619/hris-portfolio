insert into employee(
    ueid,
    employee_id,
    password,
    name,
    gender,
    birth,
    personal_phone_number,
    external_tell_number,
    internal_tell_number,
    company_email_address,
    department_code,
    position_code,
    join_date,
    employment_type,
    insert_at,
    insert_by
) values (
    '0000',
    '000000000000',
    '0000000',
    '관리자',
    'M',
    '19960619',
    '01012345678',
    '0212345678',
    '001',
    'admin@test.com',
    '00',
    '00',
    '20240610',
    '0',
    '20240610',
    '시스템'
);

insert into department(
    department_code,
    department_name,
    parent_department_code,
    department_manager_ueid,
    foundation_date,
    insert_at,
    insert_by
) values (
    '00',
    '개발부',
    null,
    '0000',
    '20240610',
    '20240610',
    '시스템'
);

insert into position(
    position_code,
    position_name,
    insert_at,
    insert_by
) values (
    '00',
    '사원',
    '20240610',
    '시스템'
);

insert into employment(
    employment_type,
    employment_name,
    employment_comment,
    insert_at,
    insert_by
) values (
    '0',
    '정규직',
    '정식 계약이 완료된 정규직을 의미합니다.',
    '20240610',
    '시스템'
);
