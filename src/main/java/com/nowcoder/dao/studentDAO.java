package com.nowcoder.dao;

import com.nowcoder.model.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface studentDAO {
    String TABLE_NAME="student";
    String INSERT_FIELD="student_name,student_class,student_tercher,student_passwrod,salt";
    String SELECT_FIELD="student_id,student_name,student_class,student_tercher,student_passwrod,salt";
    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELD,")Values(#{studentName},#{studentClass},#{studentTercher},#{studentPasswrod},#{salt})"})
            int addStudent(Student student);
    @Select({"select",SELECT_FIELD,"FROM",TABLE_NAME,"WHERE student_id=#{studentId}"})
    Student selectByStudentId(int id);
    @Select({"select",SELECT_FIELD,"FROM",TABLE_NAME,"WHERE student_name=#{studentName}"})
    Student selectByStudentName(String name);
    @Update({"update",TABLE_NAME,"SET student_name=#{studentName} where student_id=#{studentId}"})
    void updateStudent(Student student);
    @Delete({"delete from",TABLE_NAME,"where student_id=#{studentId}"})
    void deletStudentByid(int studentId);
}
