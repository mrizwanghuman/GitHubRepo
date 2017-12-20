package com.example.admin.githubrepo.gituseractivity;



import com.example.admin.githubrepo.modal.User;
import com.example.admin.githubrepo.modal.UserData;
import com.example.admin.githubrepo.util.BasePresenter;
import com.example.admin.githubrepo.util.BaseView;

import java.util.List;

/**
 * Created by  Admin on 12/19/2017.
 */

 public interface UserDetailsContractor {

      interface View extends BaseView{
          void setUser(List<User> userList);
         void showProgress(String progress);
     }
     interface Presenter extends BasePresenter<View>{
            void getGitUser(String username);
     }

}
