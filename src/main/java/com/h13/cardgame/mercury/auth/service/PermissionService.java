package com.h13.cardgame.mercury.auth.service;

import java.util.List;

import com.h13.cardgame.mercury.auth.vo.PermissionVO;
import com.h13.cardgame.mercury.dao.PermissionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

	@Autowired
    PermissionDAO permissionDAO;

	public List<PermissionVO> getAllPermission() {
		return permissionDAO.getAllPermission();
	}

	public void create(String name, String url) {
		permissionDAO.create(name, url);
	}

	public void update(long permissionId, String name, String url) {
		permissionDAO.update(permissionId, name, url);
	}

	public void delete(long permissionId) {
		permissionDAO.delete(permissionId);
	}

	public PermissionVO fetch(long id) {
		return permissionDAO.fetch(id);
	}
}
