package org.onebusaway.users.model;

import org.hibernate.annotations.AccessType;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oba_user_indices")
@AccessType("field")
public class UserIndex implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private UserIndexKey id;

  private String credentials;

  @ManyToOne(fetch = FetchType.EAGER)
  private User user;

  public UserIndexKey getId() {
    return id;
  }

  public void setId(UserIndexKey id) {
    this.id = id;
  }

  public String getCredentials() {
    return credentials;
  }

  public void setCredentials(String credentials) {
    this.credentials = credentials;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  /****
   * {@link Object} Interface
   ****/

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserIndex other = (UserIndex) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "UserIndex(id=" + id + ")";
  }

}
