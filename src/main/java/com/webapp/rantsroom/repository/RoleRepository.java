package com.webapp.rantsroom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.rantsroom.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

	@Override
	default <S extends Role> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void delete(Role entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteAll(Iterable<? extends Role> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default List<Role> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default List<Role> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <S extends Role> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	default <S extends Role> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Role getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <S extends Role> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
}
