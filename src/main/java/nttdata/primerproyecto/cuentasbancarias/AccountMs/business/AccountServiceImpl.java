package nttdata.primerproyecto.cuentasbancarias.AccountMs.business;

import nttdata.primerproyecto.cuentasbancarias.AccountMs.entity.Account;
import nttdata.primerproyecto.cuentasbancarias.AccountMs.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        if (account.getSaldo() <= 0) {
            throw new IllegalArgumentException("El saldo inicial debe ser mayor a 0.");
        }
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account deposit(Integer id, Double amount) {
        Account account = getAccountById(id);
        if (account != null) {
            account.setSaldo(account.getSaldo() + amount);
            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    public Account withdraw(Integer id, Double amount) {
        Account account = getAccountById(id);
        if (account != null && account.getSaldo() >= amount) {
            account.setSaldo(account.getSaldo() - amount);
            return accountRepository.save(account);
        }

        return null;
    }
}
