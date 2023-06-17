create table course_roadmap_db.module (
    abbreviation character varying(255) primary key not null,
    module_length integer,
    module_type character varying(255),
    name character varying(255)
);

create table course_roadmap_db.roadmap (
    roadmap_id bigint primary key not null,
    module_id character varying(255),
    name character varying(255),
    foreign key (module_id) references course_roadmap_db.module (abbreviation)
    match simple on update no action on delete no action
);

create table course_roadmap_db.tag (
    id bigint primary key not null,
    tag_text character varying(255)
);

create table course_roadmap_db.roadmap_user (
    id bigint primary key not null,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255)
);

create table course_roadmap_db.student_user (
    student_index integer primary key not null,
    student_ekts numeric(19,2),
    student_type character varying(255),
    user_id bigint,
    roadmapuserbyuserid_id bigint,
    foreign key (roadmapuserbyuserid_id) references course_roadmap_db.roadmap_user (id)
    match simple on update no action on delete no action
);


create table course_roadmap_db.staff_user (
    staff_id bigint primary key not null,
    staff_type character varying(255)
);

create table course_roadmap_db.admin_user (
    user_id bigint references roadmap_user(id) primary key not null
);

create table course_roadmap_db.semester (
    semester_id bigint primary key not null,
    date_created date,
    semester_number integer,
    semester_year integer,
    student integer not null,
    foreign key (student) references course_roadmap_db.student_user (student_index)
    match simple on update no action on delete no action
);

create table course_roadmap_db.course (
    course_code character varying(255) primary key not null,
    course_ekts numeric(19,2),
    course_type character varying(255),
    description character varying(255),
    name character varying(255)
);

create table course_roadmap_db.course_dependency (
    parent_course_of character varying(255) not null,
    child_course character varying(255) not null,
    primary key (parent_course_of, child_course),
    foreign key (child_course) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action,
    foreign key (parent_course_of) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action
);

create table course_roadmap_db.course_dependency_of (
    parent_course character varying(255) not null,
    child_course_of character varying(255) not null,
    primary key (parent_course, child_course_of),
    foreign key (parent_course) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action,
    foreign key (child_course_of) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action
);

create table course_roadmap_db.course_in_module (
    module_id character varying(255) not null,
    course_id character varying(255) not null,
    semester_available character varying(255),
    primary key (module_id, course_id),
    foreign key (course_id) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action,
    foreign key (module_id) references course_roadmap_db.module (abbreviation)
    match simple on update no action on delete no action
);

create table course_roadmap_db.course_in_roadmap (
    roadmap_id bigint not null,
    course_id character varying(255) not null,
    primary key (roadmap_id, course_id),
    foreign key (course_id) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action,
    foreign key (roadmap_id) references course_roadmap_db.roadmap (roadmap_id)
    match simple on update no action on delete no action
);

create table course_roadmap_db.course_staff (
    staff_id bigint not null,
    course_id character varying(255) not null,
    primary key (staff_id, course_id),
    foreign key (staff_id) references course_roadmap_db.staff_user (staff_id)
    match simple on update no action on delete no action,
    foreign key (course_id) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action
);

create table course_roadmap_db.course_tag (
    tag_id bigint not null,
    course_id character varying(255) not null,
    primary key (tag_id, course_id),
    foreign key (course_id) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action,
    foreign key (tag_id) references course_roadmap_db.tag (id)
    match simple on update no action on delete no action
);

create table course_roadmap_db.semester_in_roadmap (
    semester_id integer not null,
    roadmap_id bigint not null,
    primary key (semester_id, roadmap_id),
    foreign key (semester_id) references course_roadmap_db.semester (semester_id)
    match simple on update no action on delete no action,
    foreign key (roadmap_id) references course_roadmap_db.roadmap (roadmap_id)
    match simple on update no action on delete no action
);

create table course_roadmap_db.semester_course (
    semester_id bigint not null,
    course_id character varying(255) not null,
    module_id character varying(255),
    roadmap_id bigint,
    primary key (semester_id, course_id),
    foreign key (course_id) references course_roadmap_db.course (course_code)
    match simple on update no action on delete no action,
    foreign key (semester_id) references course_roadmap_db.semester (semester_id)
    match simple on update no action on delete no action,
    foreign key (roadmap_id, course_id) references course_roadmap_db.course_in_roadmap (roadmap_id, course_id)
    match simple on update no action on delete no action,
    foreign key (semester_id, roadmap_id) references course_roadmap_db.semester_in_roadmap (semester_id, roadmap_id)
    match simple on update no action on delete no action,
    foreign key (module_id, course_id) references course_roadmap_db.course_in_module (module_id, course_id)
    match simple on update no action on delete no action
);
