package pl.saqie.SimpleBank.app.component.bankaccount.usecase.dashboard;

import pl.saqie.SimpleBank.app.component.user.User;

public interface DashboardUseCase {

    DashboardDto getDashboardInformations(User user);

}
