package Low_Level_Design.Problems.DigitalWallet.services;


import java.util.UUID;

import Low_Level_Design.Problems.DigitalWallet.enums.Currency;
import Low_Level_Design.Problems.DigitalWallet.models.Account;
import Low_Level_Design.Problems.DigitalWallet.models.User;
import Low_Level_Design.Problems.DigitalWallet.repositories.IAccountRepository;
import Low_Level_Design.Problems.DigitalWallet.repositories.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    private final IAccountRepository accountRepository;

    public UserService(IUserRepository userRepository, IAccountRepository accountRepository){
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public User createUser(String name, String mobNum, Currency currency){
        String accNumber = UUID.randomUUID().toString();
        Account account = new Account(accNumber, currency);
        User user = new User(name, mobNum, account);
        // lets save them in repo
        accountRepository.save(account);
        userRepository.save(user);
        return user;
    }
}