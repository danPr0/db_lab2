package com.example.lab2.util;

public class DBConstants {

    public static final String CARS_TABLE        = "cars";
    public static final String CATEGORIES_TABLE  = "categories";
    public static final String GROUPS_TABLE      = "cohorts";
    public static final String INSTRUCTORS_TABLE = "instructors";
    public static final String STUDENTS_TABLE    = "students";
    public static final String TEACHERS_TABLE    = "teachers";

    public static final String CAR_ID          = CARS_TABLE + "." + "id";
    public static final String CAR_BRAND       = CARS_TABLE + "." + "brand";
    public static final String CAR_MODEL       = CARS_TABLE + "." + "model";
    public static final String CAR_YEAR        = CARS_TABLE + "." + "year";
    public static final String CAR_CATEGORY_ID = CARS_TABLE + "." + "category_id";

    public static final String CATEGORY_ID          = CATEGORIES_TABLE + "." + "id";
    public static final String CATEGORY_DESCRIPTION = CATEGORIES_TABLE + "." + "description";

    public static final String GROUP_ID               = GROUPS_TABLE + "." + "id";
    public static final String GROUP_LECTURES_COVERED = GROUPS_TABLE + "." + "lectures_covered";
    public static final String GROUP_START_DATE       = GROUPS_TABLE + "." + "start_date";
    public static final String GROUP_CATEGORY_ID      = GROUPS_TABLE + "." + "category_id";
    public static final String GROUP_TEACHER_ID       = GROUPS_TABLE + "." + "teacher_id";

    public static final String INSTRUCTOR_ID           = INSTRUCTORS_TABLE + "." + "id";
    public static final String INSTRUCTOR_EMAIL        = INSTRUCTORS_TABLE + "." + "email";
    public static final String INSTRUCTOR_PHONE_NUMBER = INSTRUCTORS_TABLE + "." + "phone_number";
    public static final String INSTRUCTOR_FIRST_NAME   = INSTRUCTORS_TABLE + "." + "first_name";
    public static final String INSTRUCTOR_SECOND_NAME  = INSTRUCTORS_TABLE + "." + "second_name";
    public static final String INSTRUCTOR_CAR_ID       = INSTRUCTORS_TABLE + "." + "car_id";

    public static final String STUDENT_ID             = STUDENTS_TABLE + "." + "id";
    public static final String STUDENT_EMAIL          = STUDENTS_TABLE + "." + "email";
    public static final String STUDENT_PHONE_NUMBER   = STUDENTS_TABLE + "." + "phone_number";
    public static final String STUDENT_FIRST_NAME     = STUDENTS_TABLE + "." + "first_name";
    public static final String STUDENT_SECOND_NAME    = STUDENTS_TABLE + "." + "second_name";
    public static final String STUDENT_PRACTICE_COUNT = STUDENTS_TABLE + "." + "practice_count";
    public static final String STUDENT_GROUP_ID       = STUDENTS_TABLE + "." + "group_id";
    public static final String STUDENT_INSTRUCTOR_ID  = STUDENTS_TABLE + "." + "instructor_id";

    public static final String TEACHER_ID           = TEACHERS_TABLE + "." + "id";
    public static final String TEACHER_EMAIL        = TEACHERS_TABLE + "." + "email";
    public static final String TEACHER_PHONE_NUMBER = TEACHERS_TABLE + "." + "phone_number";
    public static final String TEACHER_FIRST_NAME   = TEACHERS_TABLE + "." + "first_name";
    public static final String TEACHER_SECOND_NAME  = TEACHERS_TABLE + "." + "second_name";
}
