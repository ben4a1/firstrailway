package by.paramonov.firstrailway.repository;

import by.paramonov.firstrailway.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository{

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User save(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void delete(Long id) {
        entityManager.remove(id);
        entityManager.flush();
    }

    public void update(User entity) {
        entityManager.merge(entity);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    public List<User> findAll() {
        var criteria = entityManager.getCriteriaBuilder().createQuery(User.class);
        criteria.from(User.class);
        return entityManager.createQuery(criteria)
                .getResultList();
    }
}
