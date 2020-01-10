package my.test.receiver.repository;


import my.test.receiver.entity.MyMessage;
import org.springframework.data.repository.CrudRepository;

public interface MyMessageRepository extends CrudRepository<MyMessage, Integer> {

}