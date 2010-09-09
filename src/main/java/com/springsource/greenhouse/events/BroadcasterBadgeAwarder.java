package com.springsource.greenhouse.events;

import javax.inject.Inject;

import com.springsource.greenhouse.account.Account;

import com.springsource.greenhouse.badge.ActionTriggeredBadgeAwarder;
import com.springsource.greenhouse.badge.AwardedBadge;
import com.springsource.greenhouse.badge.BadgeRepository;

public class BroadcasterBadgeAwarder implements ActionTriggeredBadgeAwarder<EventTweetAction> {

	private BadgeRepository badgeRepository;
	
	@Inject
	public BroadcasterBadgeAwarder(BadgeRepository badgeRepository) {
		this.badgeRepository = badgeRepository;
	}
	
	public AwardedBadge awardBadgeForAction(EventTweetAction action) {
		if (alreadyAwarded(action.getAccount(), action.getEventId())) {
			return null;
		}
		return badgeRepository.createAwardedBadge(BADGE_NAME, action.getAccount(), action);
	}

	private boolean alreadyAwarded(Account account, Long eventId) {
		return false;
	}
	
	private static final String BADGE_NAME = "Broadcaster";

}