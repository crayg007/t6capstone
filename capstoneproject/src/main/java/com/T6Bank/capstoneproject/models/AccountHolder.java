package com.T6Bank.capstoneproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;





@Entity
@Table(name = "AccountHolder", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id",
                "user_id"
        })
})
public class AccountHolder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "First name is mandatory")
	String firstName;
	String middleName;
	@NotBlank(message = "Last name is mandatory")
	String lastName;
	@NotBlank(message = "SSN is mandatory")
	String SSN;
	private boolean active = false;
	
	private int numberOfSavingsAccount = 0;
	private int numberOfCheckingAccount = 0;
	private int numberOfPersonalAccount = 0;
	private int numberOfDBAAccount = 0;
	private int numberOfRolloverIRA = 0;
	private int numberOfRothIRA = 0;
	private int numberOfRegularIRA = 0;
	private int numberOfCDAccount = 0;
	private double totalBalance = 0;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private SavingsAccount[] savingsAccounts = new SavingsAccount[numberOfSavingsAccount];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private CheckingAccount[] checkingAccounts = new CheckingAccount[numberOfCheckingAccount];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private PersonalCheckingAccount[] personalAccounts = new PersonalCheckingAccount[numberOfPersonalAccount];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private DBAAccount[] DBAAccounts = new DBAAccount[numberOfDBAAccount];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private RolloverIRA[] rolloverIRA = new RolloverIRA[numberOfRolloverIRA];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private RothIRA[] rothIRA = new RothIRA[numberOfRothIRA];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private RegularIRA[] regularIRA = new RegularIRA[numberOfRegularIRA];
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	@OrderColumn
	private CDAccount[] cdAccount = new CDAccount[numberOfCDAccount];
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public AccountHolder() {}
	
	public AccountHolder(@NotBlank(message = "First name is mandatory") String firstName, String middleName,
			@NotBlank(message = "Last name is mandatory") String lastName,
			@NotBlank(message = "SSN is mandatory") String sSN, Long userId, boolean active) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		SSN = sSN;
		this.user = new User(userId);
		this.active = active;
	}



	public AccountHolder(String firstName, String middleName, String lastName, String sSN, boolean active) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.SSN = sSN;
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getUser() {
		return user;
	}

	public void setUser(Long long1) {
		this.user = new User(long1);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	
///////////////////Savings/////////
	
	public SavingsAccount addSavingsAccount(double openingBalance,boolean active) {
		SavingsAccount savings = new SavingsAccount(openingBalance,active);
		return addSavingsAccount(savings);
	}
	
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		savingsAccount.setAccountHolder(this);
		if(numberOfSavingsAccount >= savingsAccounts.length) {
			SavingsAccount[] newSavingsAccounts = new SavingsAccount[numberOfSavingsAccount + 1];
			for(int i = 0 ; i < savingsAccounts.length  ; i++) {
				newSavingsAccounts[i] = savingsAccounts[i];
			} 
			savingsAccounts = newSavingsAccounts;
		}			
		savingsAccounts[numberOfSavingsAccount] = savingsAccount;
		numberOfSavingsAccount++;
		getCombinedBalance();
		return savingsAccount;
	}
	
	public SavingsAccount[] getSavingsAccount() {
		return savingsAccounts;
	}
	
	public int getNumberOfSavingsAccount() {
		return numberOfSavingsAccount;
	}
	
	public double getSavingsBalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfSavingsAccount();i++) {
		total += savingsAccounts[i].getBalance();
		}
		return total;
	}
	
/////////Checking//////////
	
	public CheckingAccount addCheckingAccount(double openingBalance,boolean active) {
		CheckingAccount checking = new CheckingAccount(openingBalance,active);
		return addCheckingAccount(checking);
	}
	
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		checkingAccount.setAccountHolder(this);
		if(numberOfCheckingAccount >= checkingAccounts.length) {
			CheckingAccount[] newCheckingAccounts = new CheckingAccount[numberOfCheckingAccount + 1];
			for(int i = 0 ; i < checkingAccounts.length  ; i++) {
				newCheckingAccounts[i] = checkingAccounts[i];
			} 
			checkingAccounts = newCheckingAccounts;
		}			
		checkingAccounts[numberOfCheckingAccount] = checkingAccount;
		numberOfCheckingAccount++;
		getCombinedBalance();
		return checkingAccount;
	}
	
	public CheckingAccount[] getCheckingAccount() {
		return checkingAccounts;
	}
	
	public int getNumberOfCheckingAccount() {
		return numberOfCheckingAccount;
	}
	
	public double getCheckingBalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfCheckingAccount();i++) {
		total += checkingAccounts[i].getBalance();
		}
		return total;
	}
	
///////Personal Checking
	
	public PersonalCheckingAccount addPersonalCheckingAccount(double openingBalance,boolean active) {
		PersonalCheckingAccount personal = new PersonalCheckingAccount(openingBalance,active);
		return addPersonalCheckingAccount(personal);
	}
	
	public PersonalCheckingAccount addPersonalCheckingAccount(PersonalCheckingAccount personalAccount) {
		personalAccount.setAccountHolder(this);
		if(numberOfPersonalAccount >= personalAccounts.length) {
			PersonalCheckingAccount[] newPersonalAccounts = new PersonalCheckingAccount[numberOfPersonalAccount + 1];
			for(int i = 0 ; i < personalAccounts.length  ; i++) {
				newPersonalAccounts[i] = personalAccounts[i];
			} 
			personalAccounts = newPersonalAccounts;
		}			
		personalAccounts[numberOfPersonalAccount] = personalAccount;
		numberOfPersonalAccount++;
		getCombinedBalance();
		return personalAccount;
	}
	
	public PersonalCheckingAccount[] getPersonalCheckingAccount() {
		return personalAccounts;
	}
	
	public int getNumberOfPersonalAccount() {
		return numberOfPersonalAccount;
	}
	
	public double getPersonalCheckingBalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfPersonalAccount();i++) {
		total += personalAccounts[i].getBalance();
		}
		return total;
	}
	
///////DBA//////
	
	public DBAAccount addDBAAccount(double openingBalance,boolean active) {
		DBAAccount DBA = new DBAAccount(openingBalance,active);
		return addDBAAccount(DBA);
	}
	
	public DBAAccount addDBAAccount(DBAAccount DBAAccount) {
		DBAAccount.setAccountHolder(this);
		if(numberOfDBAAccount >= DBAAccounts.length) {
			DBAAccount[] newDBAAccounts = new DBAAccount[numberOfDBAAccount + 1];
			for(int i = 0 ; i < DBAAccounts.length  ; i++) {
				newDBAAccounts[i] = DBAAccounts[i];
			} 
			DBAAccounts = newDBAAccounts;
		}			
		DBAAccounts[numberOfDBAAccount] = DBAAccount;
		numberOfDBAAccount++;
		getCombinedBalance();
		return DBAAccount;
	}
	
	public DBAAccount[] getDBAAccount() {
		return DBAAccounts;
	}
	
	public int getNumberOfDBAAccount() {
		return numberOfDBAAccount;
	}
	
	public double getDBABalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfDBAAccount();i++) {
		total += DBAAccounts[i].getBalance();
		}
		return total;
	}
	
///////RolloverIRA//////
	
	public RolloverIRA addRolloverIRA(double openingBalance,boolean active) {
		RolloverIRA rollover = new RolloverIRA(openingBalance,active);
		return addRolloverIRA(rollover);
	}
	
	public RolloverIRA addRolloverIRA(RolloverIRA rollover) {
		rollover.setAccountHolder(this);
		if(numberOfRolloverIRA >= rolloverIRA.length) {
			RolloverIRA[] newRolloverIRA = new RolloverIRA[numberOfRolloverIRA + 1];
			for(int i = 0 ; i < rolloverIRA.length  ; i++) {
				newRolloverIRA[i] = rolloverIRA[i];
			} 
			rolloverIRA = newRolloverIRA;
		}			
		rolloverIRA[numberOfRolloverIRA] = rollover;
		numberOfRolloverIRA++;
		getCombinedBalance();
		return rollover;
	}
	
	public RolloverIRA[] getRolloverIRA() {
		return rolloverIRA;
	}
	
	public int getNumberOfRolloverIRA() {
		return numberOfDBAAccount;
	}
	
	public double getRolloverIRABalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfRolloverIRA();i++) {
		total += rolloverIRA[i].getBalance();
		}
		return total;
	}
	
//////RothIRA//////
	
	public RothIRA addRothIRA(double openingBalance,boolean active) {
		RothIRA roth = new RothIRA(openingBalance,active);
		return addRothIRA(roth);
	}
	
	public RothIRA addRothIRA(RothIRA roth) {
		roth.setAccountHolder(this);
		if(numberOfRothIRA >= rothIRA.length) {
			RothIRA[] newRothIRA = new RothIRA[numberOfRothIRA + 1];
			for(int i = 0 ; i < rothIRA.length  ; i++) {
				newRothIRA[i] = rothIRA[i];
			} 
			rothIRA = newRothIRA;
		}			
		rothIRA[numberOfRothIRA] = roth;
		numberOfRothIRA++;
		getCombinedBalance();
		return roth;
	}
	
	public RothIRA[] getRothIRA() {
		return rothIRA;
	}
	
	public int getNumberOfRothIRA() {
		return numberOfRothIRA;
	}
	
	public double getRothIRABalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfRothIRA();i++) {
		total += rothIRA[i].getBalance();
		}
		return total;
	}
	
///////RegularIRA//////
	
	public RegularIRA addRegularIRA(double openingBalance,boolean active) {
		RegularIRA regular = new RegularIRA(openingBalance,active);
		return addRegularIRA(regular);
	}
	
	public RegularIRA addRegularIRA(RegularIRA regular) {
		regular.setAccountHolder(this);
		if(numberOfRegularIRA >= regularIRA.length) {
			RegularIRA[] newRegularIRA = new RegularIRA[numberOfRegularIRA + 1];
			for(int i = 0 ; i < regularIRA.length  ; i++) {
				newRegularIRA[i] = regularIRA[i];
			} 
			regularIRA = newRegularIRA;
		}			
		regularIRA[numberOfRegularIRA] = regular;
		numberOfRegularIRA++;
		getCombinedBalance();
		return regular;
	}
	
	public RegularIRA[] getRegularIRA() {
		return regularIRA;
	}
	
	public int getNumberOfRegularIRA() {
		return numberOfRegularIRA;
	}
	
	public double getRegularIRABalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfRegularIRA();i++) {
		total += regularIRA[i].getBalance();
		}
		return total;
	}
	
///////CDAccount////////
	
	public CDAccount addCDAccount(CDOffering offering ,double openingBalance,boolean active) {
		CDAccount cd = new CDAccount(offering, openingBalance,active);
		return addCDAccount(cd);
	}
	
	public CDAccount addCDAccount(CDAccount cd) {
		cd.setAccountHolder(this);
		if(numberOfCDAccount >= cdAccount.length) {
			CDAccount[] newCDAccount = new CDAccount[numberOfCDAccount + 1];
			for(int i = 0 ; i < cdAccount.length  ; i++) {
				newCDAccount[i] = cdAccount[i];
			} 
			cdAccount = newCDAccount;
		}			
		cdAccount[numberOfCDAccount] = cd;
		numberOfCDAccount++;
		getCombinedBalance();
		return cd;
	}
	
	public CDAccount[] getCDAccount() {
		return cdAccount;
	}
	
	public int getNumberOfCDAccount() {
		return numberOfCDAccount;
	}
	
	public double getCDAccountBalance() {
		double total = 0;
		for(int i = 0; i < getNumberOfCDAccount();i++) {
		total += cdAccount[i].getBalance();
		}
		return total;
	}
	
	public double getCombinedBalance() {
		return totalBalance = getSavingsBalance() + getCheckingBalance()+ getPersonalCheckingBalance() + getDBABalance() +
				getRolloverIRABalance() + getRothIRABalance() + getRegularIRABalance() + getCDAccountBalance();
	}

}
