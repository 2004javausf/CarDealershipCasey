package com.cardealer.menu;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.cardealer.beans.AcceptedOffers;
import com.cardealer.beans.CarOwner;
import com.cardealer.beans.UserCreds;
import com.cardealer.daoimpl.AcceptedOffersDAOImpl;
import com.cardealer.daoimpl.CarOwnerDAOImpl;
import com.cardealer.daoimpl.PendingOffersDAOImpl;
import com.cardealer.util.FlushScanner;
import com.cardealer.util.Validate;

public class Customer {

	private static CarOwnerDAOImpl codi = new CarOwnerDAOImpl();
	private static PendingOffersDAOImpl podi = new PendingOffersDAOImpl();
	private static AcceptedOffersDAOImpl aodi = new AcceptedOffersDAOImpl();

	private static DecimalFormat df = new DecimalFormat("#.##");

	public static void customerMenu(UserCreds user, Scanner in) {

		System.out.println("Please select what you would like to do:");
		System.out.println("1. View cars on lot");
		System.out.println("2. Make an offer on a car");
		System.out.println("3. View owned car(s)");
		System.out.println("4. View payment(s) remaining on your car");
		System.out.println("5. Exit");

		switch (Validate.numVal(5, in)) {
		case 1:
			viewLot();
			goAgain(user, in);
			break;
		case 2:
			offerCar(user, in);
			goAgain(user, in);
			break;
		case 3:
			viewOwned(user);
			goAgain(user, in);
			break;
		case 4:
			viewPayment(user);
			goAgain(user, in);
			break;
		case 5:
			System.out.println("Have an excellent day!");
			break;
		}
	}

	private static void goAgain(UserCreds user, Scanner in) {
		if (Validate.yn("Would you like to do something else? Y/N", in) == 'y') {
			customerMenu(user, in);
		}
	}

	private static void viewPayment(UserCreds user) {
		ArrayList<CarOwner> owned;
		try {
			owned = codi.getOwned(user.getId());
			if (owned.isEmpty()) {
				System.out.println(
						"Who are you tryin' to fool. You don't own any cars! Now spend your money on our cars already! Make an offer!");
			} else {
				ArrayList<AcceptedOffers> payment;
				payment = aodi.getPayment(user.getId());
				for (int i = 0; i < payment.size(); i++) {
					System.out.println("Car ID " + payment.get(i).getCarId() + " has " + payment.get(i).getMonthsLeft()
							+ " months left of payment to go at a price of $"
							+ df.format(payment.get(i).getAmountOwed()));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void viewOwned(UserCreds user) {
		ArrayList<CarOwner> owned;
		try {
			owned = codi.getOwned(user.getId());
			if (owned.isEmpty()) {
				System.out.println("You own no cars! Get to buyin'! These deals won't last forever!");
			} else {
				System.out.println("Here's a list of the IDs of the cars you own:");
				for (int i = 0; i < owned.size(); i++) {
					System.out.println(owned.get(i).getCarId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void offerCar(UserCreds user, Scanner in) {
		System.out.println("Which car number would you like to make an offer on?");
		int carId = in.nextInt();
		FlushScanner.flush(in);
		boolean isFound = false;
		ArrayList<CarOwner> lot;
		try {
			lot = codi.getLot();
			for (int i = 0; i < lot.size(); i++) {
				if (lot.get(i).getCarId().equals(carId)) {
					isFound = true;
					i = lot.size();
				}
			}
			if (isFound) {
				System.out.println("How much would you like to make an offer for?");
				double offer = in.nextDouble();
				podi.createOffer(carId, user.getId(), offer);
			} else {// if car's not on the lot, ask to try again
				if (Validate.yn("Car not found in lot. Try again? Y/N", in) == 'y') {
					offerCar(user, in);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void viewLot() {
		System.out.println("The following are the cars for sale on the lot:");
		try {
			ArrayList<CarOwner> lot = codi.getLot();
			if (lot.isEmpty()) {
				System.out.println(
						"The lot is currently empty. Maybe you were too late. These crazy deals are probably too crazy!");
			} else {
				for (int i = 0; i < lot.size(); i++) {
					System.out.println("Car number " + lot.get(i).getCarId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
