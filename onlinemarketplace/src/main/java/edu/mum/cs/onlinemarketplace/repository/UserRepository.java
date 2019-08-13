package edu.mum.cs.onlinemarketplace.repository;
import edu.mum.cs.onlinemarketplace.domain.Address;
import edu.mum.cs.onlinemarketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    public List<User>findFollowersById(Long sid);

    @Query("SELECT u FROM User u where u.email like %:email%")
    public List<User> findByEmail(String email);

}
