package com.example.payment.service.creditCard;

import com.example.payment.dao.DaoFactory;
import com.example.payment.dao.creditCard.CreditCardDao;
import com.example.payment.entity.Account;
import com.example.payment.entity.CardType;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.dto.CardDto;
import com.example.payment.exception.AccountExistException;

import java.time.LocalDate;
import java.util.List;

public class CreditCardServiceImpl implements CreditCardService{
    private static final int END_DATA = 4;
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<CreditCard> findAllCardsByAccount(Long accountId) {
        try (CreditCardDao cardDao = daoFactory.createCreditCardDao()){
            return cardDao.findAllByAccount(accountId);
        }
    }

    @Override
    public boolean createCard(Account account, CardDto cardDto) {
        try (CreditCardDao cardDao = daoFactory.createCreditCardDao()){
            if (isCardWithTypeExist(cardDto.getCardType(),cardDao , account.getId())) {
                throw new AccountExistException("There is an card with that type:" + cardDto.getCardType());
            }
            CreditCard cardToCreate = new CreditCard();
            cardToCreate.setAccount(account);
            cardToCreate.setCardType(cardDto.getCardType());
            cardToCreate.setEndDate( LocalDate.now().plusYears(END_DATA));
            cardToCreate.setPin(cardDto.getPin());
            cardToCreate.setNumber(CardGenerator.generateRandomNumber(cardDao));
            cardToCreate.setCvv(CardGenerator.generateRandomCvv());
            return cardDao.create(cardToCreate);
        }
    }

    private boolean isCardWithTypeExist(CardType cardType , CreditCardDao cardDao , Long accountId){
        return  cardDao.findByTypeCard(cardType,accountId).isPresent();
    }
}
