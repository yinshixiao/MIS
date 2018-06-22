package com.open.mis.modules.login.entity;

/*角色表sys_role*/
public class Role {

	private String roleCode;
	
	private String roleName;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role:{roleCode:" + roleCode + ", roleName:" + roleName + "}";
	}
	
	
}
