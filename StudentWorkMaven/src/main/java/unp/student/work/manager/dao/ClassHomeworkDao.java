package unp.student.work.manager.dao;
import java.sql.SQLException;
import java.util.List;

import unp.student.work.manager.domain.ClassHomework;
/**
* Description: TODO
* @author 
* @date 2017��2��25�� ����2:57:56
 */
public interface ClassHomeworkDao extends BaseDao<ClassHomework> {
	List findByPage(int pageNo, int pageSize);

	List findById(int id, int pageSize);
}