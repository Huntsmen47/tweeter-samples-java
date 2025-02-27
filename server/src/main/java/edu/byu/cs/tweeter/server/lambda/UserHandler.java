package edu.byu.cs.tweeter.server.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.byu.cs.tweeter.model.net.request.UserRequest;
import edu.byu.cs.tweeter.model.net.response.UserResponse;
import edu.byu.cs.tweeter.server.dao.ConcreteDaoFactory;
import edu.byu.cs.tweeter.server.dao.dao_interfaces.DAOFactory;
import edu.byu.cs.tweeter.server.service.UserService;

public class UserHandler implements RequestHandler<UserRequest, UserResponse> {
    @Override
    public UserResponse handleRequest(UserRequest input, Context context) {
        UserService service = new UserService();
        DAOFactory daoFactory = new ConcreteDaoFactory();
        return service.getUser(input,daoFactory);
    }
}
