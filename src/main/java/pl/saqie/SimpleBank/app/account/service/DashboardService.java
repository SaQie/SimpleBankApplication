package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.dto.DashboardDto;
import pl.saqie.SimpleBank.app.user.model.User;

public interface DashboardService {

    DashboardDto getDashboardInformations(User user);

}
