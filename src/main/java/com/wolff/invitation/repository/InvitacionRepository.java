package com.wolff.invitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolff.invitation.model.Invitacion;

@Repository
public interface InvitacionRepository extends JpaRepository<Invitacion, String> {

}
