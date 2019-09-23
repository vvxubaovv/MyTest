package com.xubao.test.simpleTest.protobufTest.save;


import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Random;

public class A
{
	private String ucjaf = "";
	
	private int sdkType;

	protected String name = "";
	protected String maskName = "";

	protected int ccjaAdd;
	protected int ccjaBonus;
	protected int ccjaSystem;
	protected int ccjaUse;
	protected int ccjaStatus;

	protected String pcjafNumber = "";
	protected String pcjafVerifyCode = "";
	protected String pcjafVerifyNumber = "";
	protected Timestamp pcjafVerifyCodeSendTime;
	protected int pcjafNumberBindCcjaf;
	
	protected int currency;

	private String pcjaf = "";
	protected String os = "";
	protected String acjaf = "";
	protected String adId = "";

	protected String deviceName = "";
	protected String systemName = "";
	
	protected int vipExp;
	protected boolean showVip;
	
	protected int memory;

	protected int level;
	protected long exp;
	protected long money;
	
	protected String avatarUrl = "";

	
	protected String deviceCode;

	protected int status;
	protected Timestamp lastLoginTime;
	protected Timestamp lastLogoutTime;
	protected Timestamp dailyUpdateTime;
	protected Timestamp lastLevelUpTime;
	protected Timestamp lastWorldMailReceiveTime;
	protected int onlineDayCcjaf;
	protected int seriesLoginDay;       
	
	protected long onlineDuration;

	protected String playEntranceType;
	
	protected int tournamentType = 0;
	protected long tournamentId = 0L;
	protected int roomServerId = 0;
	protected Timestamp tournamentEnterTime;
	protected Timestamp lastMatchEscapeTime;
	protected Timestamp matchEscapeCoolDownTime;
	protected boolean needBiddingCost = false;
	
	protected int rcjaGameCcjaf;
	
	protected int rcjaGameEscapeCcjaf;
	
	protected int rcjaAsGoodWinCcjaf;
	
	protected int rcjaAsBadWinCcjaf;
	
	protected int rcjaAsGoodLoseCcjaf;
	
	protected int rcjaAsBadLoseCcjaf;

	
	protected int gameWinCcjaf;
	
	protected int surviveWinCcjaf;
	
	protected int lostWinCcjaf;
	
	protected int guardWinCcjaf;
	
	protected int hiddenerWinCcjaf;
	
	protected int suspicionWinCcjaf;
	
	protected int hunterWinCcjaf;
	
	protected int guessLostCcjaf;
	

	protected long islandVersion = System.currentTimeMillis();
	protected long islandId = 0;
	private int gameServerId = 0;
	
	protected int dailyRandomTaskReplaceChances = 0;
	protected long dailyRandomTaskReplaceTime; 
	
	protected int dailyRandomTaskAcceptChances = 0;
	protected long dailyRandomTaskAcceptTime; 


	protected long teamId = 0;
	

	protected String roomZone;

	protected int usingHeroId;
	

	public String getUcjaf()
	{
		return ucjaf;
	}

	public void setUcjaf(String ucjaf)
	{
		this.ucjaf = ucjaf;
	}

	public int getSdkType()
	{
		return sdkType;
	}

	public void setSdkType(int sdkType)
	{
		this.sdkType = sdkType;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMaskName()
	{
		return maskName;
	}

	public void setMaskName(String maskName)
	{
		this.maskName = maskName;
	}

	public int getCcjaAdd()
	{
		return ccjaAdd;
	}

	public void setCcjaAdd(int ccjaAdd)
	{
		this.ccjaAdd = ccjaAdd;
	}

	public int getCcjaBonus()
	{
		return ccjaBonus;
	}

	public void setCcjaBonus(int ccjaBonus)
	{
		this.ccjaBonus = ccjaBonus;
	}

	public int getCcjaSystem()
	{
		return ccjaSystem;
	}

	public void setCcjaSystem(int ccjaSystem)
	{
		this.ccjaSystem = ccjaSystem;
	}

	public int getCcjaUse()
	{
		return ccjaUse;
	}

	public void setCcjaUse(int ccjaUse)
	{
		this.ccjaUse = ccjaUse;
	}

	public int getCcjaStatus()
	{
		return ccjaStatus;
	}

	public void setCcjaStatus(int ccjaStatus)
	{
		this.ccjaStatus = ccjaStatus;
	}

	public String getPcjafNumber()
	{
		return pcjafNumber;
	}

	public void setPcjafNumber(String pcjafNumber)
	{
		this.pcjafNumber = pcjafNumber;
	}

	public String getPcjafVerifyCode()
	{
		return pcjafVerifyCode;
	}

	public void setPcjafVerifyCode(String pcjafVerifyCode)
	{
		this.pcjafVerifyCode = pcjafVerifyCode;
	}

	public String getPcjafVerifyNumber()
	{
		return pcjafVerifyNumber;
	}

	public void setPcjafVerifyNumber(String pcjafVerifyNumber)
	{
		this.pcjafVerifyNumber = pcjafVerifyNumber;
	}

	public Timestamp getPcjafVerifyCodeSendTime()
	{
		return pcjafVerifyCodeSendTime;
	}

	public void setPcjafVerifyCodeSendTime(Timestamp pcjafVerifyCodeSendTime)
	{
		this.pcjafVerifyCodeSendTime = pcjafVerifyCodeSendTime;
	}

	public int getPcjafNumberBindCcjaf()
	{
		return pcjafNumberBindCcjaf;
	}

	public void setPcjafNumberBindCcjaf(int pcjafNumberBindCcjaf)
	{
		this.pcjafNumberBindCcjaf = pcjafNumberBindCcjaf;
	}

	public int getCurrency()
	{
		return currency;
	}

	public void setCurrency(int currency)
	{
		this.currency = currency;
	}

	public String getPcjaf()
	{
		return pcjaf;
	}

	public void setPcjaf(String pcjaf)
	{
		this.pcjaf = pcjaf;
	}

	public String getOs()
	{
		return os;
	}

	public void setOs(String os)
	{
		this.os = os;
	}

	public String getAcjaf()
	{
		return acjaf;
	}

	public void setAcjaf(String acjaf)
	{
		this.acjaf = acjaf;
	}

	public String getAdId()
	{
		return adId;
	}

	public void setAdId(String adId)
	{
		this.adId = adId;
	}

	public String getDeviceName()
	{
		return deviceName;
	}

	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
	}

	public String getSystemName()
	{
		return systemName;
	}

	public void setSystemName(String systemName)
	{
		this.systemName = systemName;
	}

	public int getVipExp()
	{
		return vipExp;
	}

	public void setVipExp(int vipExp)
	{
		this.vipExp = vipExp;
	}

	public boolean isShowVip()
	{
		return showVip;
	}

	public void setShowVip(boolean showVip)
	{
		this.showVip = showVip;
	}

	public int getMemory()
	{
		return memory;
	}

	public void setMemory(int memory)
	{
		this.memory = memory;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public long getExp()
	{
		return exp;
	}

	public void setExp(long exp)
	{
		this.exp = exp;
	}

	public long getMoney()
	{
		return money;
	}

	public void setMoney(long money)
	{
		this.money = money;
	}

	public String getAvatarUrl()
	{
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl)
	{
		this.avatarUrl = avatarUrl;
	}

	public String getDeviceCode()
	{
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode)
	{
		this.deviceCode = deviceCode;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public Timestamp getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	public Timestamp getLastLogoutTime()
	{
		return lastLogoutTime;
	}

	public void setLastLogoutTime(Timestamp lastLogoutTime)
	{
		this.lastLogoutTime = lastLogoutTime;
	}

	public Timestamp getDailyUpdateTime()
	{
		return dailyUpdateTime;
	}

	public void setDailyUpdateTime(Timestamp dailyUpdateTime)
	{
		this.dailyUpdateTime = dailyUpdateTime;
	}

	public Timestamp getLastLevelUpTime()
	{
		return lastLevelUpTime;
	}

	public void setLastLevelUpTime(Timestamp lastLevelUpTime)
	{
		this.lastLevelUpTime = lastLevelUpTime;
	}

	public Timestamp getLastWorldMailReceiveTime()
	{
		return lastWorldMailReceiveTime;
	}

	public void setLastWorldMailReceiveTime(Timestamp lastWorldMailReceiveTime)
	{
		this.lastWorldMailReceiveTime = lastWorldMailReceiveTime;
	}

	public int getOnlineDayCcjaf()
	{
		return onlineDayCcjaf;
	}

	public void setOnlineDayCcjaf(int onlineDayCcjaf)
	{
		this.onlineDayCcjaf = onlineDayCcjaf;
	}

	public int getSeriesLoginDay()
	{
		return seriesLoginDay;
	}

	public void setSeriesLoginDay(int seriesLoginDay)
	{
		this.seriesLoginDay = seriesLoginDay;
	}

	public long getOnlineDuration()
	{
		return onlineDuration;
	}

	public void setOnlineDuration(long onlineDuration)
	{
		this.onlineDuration = onlineDuration;
	}


	public String getPlayEntranceType()
	{
		return playEntranceType;
	}

	public void setPlayEntranceType(String playEntranceType)
	{
		this.playEntranceType = playEntranceType;
	}

	public int getTournamentType()
	{
		return tournamentType;
	}

	public void setTournamentType(int tournamentType)
	{
		this.tournamentType = tournamentType;
	}

	public long getTournamentId()
	{
		return tournamentId;
	}

	public void setTournamentId(long tournamentId)
	{
		this.tournamentId = tournamentId;
	}

	public int getRoomServerId()
	{
		return roomServerId;
	}

	public void setRoomServerId(int roomServerId)
	{
		this.roomServerId = roomServerId;
	}

	public Timestamp getTournamentEnterTime()
	{
		return tournamentEnterTime;
	}

	public void setTournamentEnterTime(Timestamp tournamentEnterTime)
	{
		this.tournamentEnterTime = tournamentEnterTime;
	}

	public Timestamp getLastMatchEscapeTime()
	{
		return lastMatchEscapeTime;
	}

	public void setLastMatchEscapeTime(Timestamp lastMatchEscapeTime)
	{
		this.lastMatchEscapeTime = lastMatchEscapeTime;
	}

	public Timestamp getMatchEscapeCoolDownTime()
	{
		return matchEscapeCoolDownTime;
	}

	public void setMatchEscapeCoolDownTime(Timestamp matchEscapeCoolDownTime)
	{
		this.matchEscapeCoolDownTime = matchEscapeCoolDownTime;
	}

	public boolean isNeedBiddingCost()
	{
		return needBiddingCost;
	}

	public void setNeedBiddingCost(boolean needBiddingCost)
	{
		this.needBiddingCost = needBiddingCost;
	}


	public int getRcjaGameCcjaf()
	{
		return rcjaGameCcjaf;
	}

	public void setRcjaGameCcjaf(int rcjaGameCcjaf)
	{
		this.rcjaGameCcjaf = rcjaGameCcjaf;
	}

	public int getRcjaGameEscapeCcjaf()
	{
		return rcjaGameEscapeCcjaf;
	}

	public void setRcjaGameEscapeCcjaf(int rcjaGameEscapeCcjaf)
	{
		this.rcjaGameEscapeCcjaf = rcjaGameEscapeCcjaf;
	}

	public int getRcjaAsGoodWinCcjaf()
	{
		return rcjaAsGoodWinCcjaf;
	}

	public void setRcjaAsGoodWinCcjaf(int rcjaAsGoodWinCcjaf)
	{
		this.rcjaAsGoodWinCcjaf = rcjaAsGoodWinCcjaf;
	}

	public int getRcjaAsBadWinCcjaf()
	{
		return rcjaAsBadWinCcjaf;
	}

	public void setRcjaAsBadWinCcjaf(int rcjaAsBadWinCcjaf)
	{
		this.rcjaAsBadWinCcjaf = rcjaAsBadWinCcjaf;
	}

	public int getRcjaAsGoodLoseCcjaf()
	{
		return rcjaAsGoodLoseCcjaf;
	}

	public void setRcjaAsGoodLoseCcjaf(int rcjaAsGoodLoseCcjaf)
	{
		this.rcjaAsGoodLoseCcjaf = rcjaAsGoodLoseCcjaf;
	}

	public int getRcjaAsBadLoseCcjaf()
	{
		return rcjaAsBadLoseCcjaf;
	}

	public void setRcjaAsBadLoseCcjaf(int rcjaAsBadLoseCcjaf)
	{
		this.rcjaAsBadLoseCcjaf = rcjaAsBadLoseCcjaf;
	}

	public int getGameWinCcjaf()
	{
		return gameWinCcjaf;
	}

	public void setGameWinCcjaf(int gameWinCcjaf)
	{
		this.gameWinCcjaf = gameWinCcjaf;
	}

	public int getSurviveWinCcjaf()
	{
		return surviveWinCcjaf;
	}

	public void setSurviveWinCcjaf(int surviveWinCcjaf)
	{
		this.surviveWinCcjaf = surviveWinCcjaf;
	}

	public int getLostWinCcjaf()
	{
		return lostWinCcjaf;
	}

	public void setLostWinCcjaf(int lostWinCcjaf)
	{
		this.lostWinCcjaf = lostWinCcjaf;
	}

	public int getGuardWinCcjaf()
	{
		return guardWinCcjaf;
	}

	public void setGuardWinCcjaf(int guardWinCcjaf)
	{
		this.guardWinCcjaf = guardWinCcjaf;
	}

	public int getHiddenerWinCcjaf()
	{
		return hiddenerWinCcjaf;
	}

	public void setHiddenerWinCcjaf(int hiddenerWinCcjaf)
	{
		this.hiddenerWinCcjaf = hiddenerWinCcjaf;
	}

	public int getSuspicionWinCcjaf()
	{
		return suspicionWinCcjaf;
	}

	public void setSuspicionWinCcjaf(int suspicionWinCcjaf)
	{
		this.suspicionWinCcjaf = suspicionWinCcjaf;
	}

	public int getHunterWinCcjaf()
	{
		return hunterWinCcjaf;
	}

	public void setHunterWinCcjaf(int hunterWinCcjaf)
	{
		this.hunterWinCcjaf = hunterWinCcjaf;
	}

	public int getGuessLostCcjaf()
	{
		return guessLostCcjaf;
	}

	public void setGuessLostCcjaf(int guessLostCcjaf)
	{
		this.guessLostCcjaf = guessLostCcjaf;
	}


	public long getIslandVersion()
	{
		return islandVersion;
	}

	public void setIslandVersion(long islandVersion)
	{
		this.islandVersion = islandVersion;
	}

	public long getIslandId()
	{
		return islandId;
	}

	public void setIslandId(long islandId)
	{
		this.islandId = islandId;
	}

	public int getGameServerId()
	{
		return gameServerId;
	}

	public void setGameServerId(int gameServerId)
	{
		this.gameServerId = gameServerId;
	}


	public int getDailyRandomTaskReplaceChances()
	{
		return dailyRandomTaskReplaceChances;
	}

	public void setDailyRandomTaskReplaceChances(int dailyRandomTaskReplaceChances)
	{
		this.dailyRandomTaskReplaceChances = dailyRandomTaskReplaceChances;
	}

	public long getDailyRandomTaskReplaceTime()
	{
		return dailyRandomTaskReplaceTime;
	}

	public void setDailyRandomTaskReplaceTime(long dailyRandomTaskReplaceTime)
	{
		this.dailyRandomTaskReplaceTime = dailyRandomTaskReplaceTime;
	}

	public int getDailyRandomTaskAcceptChances()
	{
		return dailyRandomTaskAcceptChances;
	}

	public void setDailyRandomTaskAcceptChances(int dailyRandomTaskAcceptChances)
	{
		this.dailyRandomTaskAcceptChances = dailyRandomTaskAcceptChances;
	}

	public long getDailyRandomTaskAcceptTime()
	{
		return dailyRandomTaskAcceptTime;
	}

	public void setDailyRandomTaskAcceptTime(long dailyRandomTaskAcceptTime)
	{
		this.dailyRandomTaskAcceptTime = dailyRandomTaskAcceptTime;
	}

	public long getTeamId()
	{
		return teamId;
	}

	public void setTeamId(long teamId)
	{
		this.teamId = teamId;
	}

	public String getRoomZone()
	{
		return roomZone;
	}

	public void setRoomZone(String roomZone)
	{
		this.roomZone = roomZone;
	}

	public int getUsingHeroId()
	{
		return usingHeroId;
	}

	public void setUsingHeroId(int usingHeroId)
	{
		this.usingHeroId = usingHeroId;
	}

	@Override
	public String toString()
	{
		return "A{" +
				"ucjaf='" + ucjaf + '\'' +
				", sdkType=" + sdkType +
				", name='" + name + '\'' +
				", maskName='" + maskName + '\'' +
				", ccjaAdd=" + ccjaAdd +
				", ccjaBonus=" + ccjaBonus +
				", ccjaSystem=" + ccjaSystem +
				", ccjaUse=" + ccjaUse +
				", ccjaStatus=" + ccjaStatus +
				", pcjafNumber='" + pcjafNumber + '\'' +
				", pcjafVerifyCode='" + pcjafVerifyCode + '\'' +
				", pcjafVerifyNumber='" + pcjafVerifyNumber + '\'' +
				", pcjafVerifyCodeSendTime=" + pcjafVerifyCodeSendTime +
				", pcjafNumberBindCcjaf=" + pcjafNumberBindCcjaf +
				", currency=" + currency +
				", pcjaf='" + pcjaf + '\'' +
				", os='" + os + '\'' +
				", acjaf='" + acjaf + '\'' +
				", adId='" + adId + '\'' +
				", deviceName='" + deviceName + '\'' +
				", systemName='" + systemName + '\'' +
				", vipExp=" + vipExp +
				", showVip=" + showVip +
				", memory=" + memory +
				", level=" + level +
				", exp=" + exp +
				", money=" + money +
				", avatarUrl='" + avatarUrl + '\'' +
				", deviceCode='" + deviceCode + '\'' +
				", status=" + status +
				", lastLoginTime=" + lastLoginTime +
				", lastLogoutTime=" + lastLogoutTime +
				", dailyUpdateTime=" + dailyUpdateTime +
				", lastLevelUpTime=" + lastLevelUpTime +
				", lastWorldMailReceiveTime=" + lastWorldMailReceiveTime +
				", onlineDayCcjaf=" + onlineDayCcjaf +
				", seriesLoginDay=" + seriesLoginDay +
				", onlineDuration=" + onlineDuration +
				", playEntranceType='" + playEntranceType + '\'' +
				", tournamentType=" + tournamentType +
				", tournamentId=" + tournamentId +
				", roomServerId=" + roomServerId +
				", tournamentEnterTime=" + tournamentEnterTime +
				", lastMatchEscapeTime=" + lastMatchEscapeTime +
				", matchEscapeCoolDownTime=" + matchEscapeCoolDownTime +
				", needBiddingCost=" + needBiddingCost +
				", rcjaGameCcjaf=" + rcjaGameCcjaf +
				", rcjaGameEscapeCcjaf=" + rcjaGameEscapeCcjaf +
				", rcjaAsGoodWinCcjaf=" + rcjaAsGoodWinCcjaf +
				", rcjaAsBadWinCcjaf=" + rcjaAsBadWinCcjaf +
				", rcjaAsGoodLoseCcjaf=" + rcjaAsGoodLoseCcjaf +
				", rcjaAsBadLoseCcjaf=" + rcjaAsBadLoseCcjaf +
				", gameWinCcjaf=" + gameWinCcjaf +
				", surviveWinCcjaf=" + surviveWinCcjaf +
				", lostWinCcjaf=" + lostWinCcjaf +
				", guardWinCcjaf=" + guardWinCcjaf +
				", hiddenerWinCcjaf=" + hiddenerWinCcjaf +
				", suspicionWinCcjaf=" + suspicionWinCcjaf +
				", hunterWinCcjaf=" + hunterWinCcjaf +
				", guessLostCcjaf=" + guessLostCcjaf +
				", islandVersion=" + islandVersion +
				", islandId=" + islandId +
				", gameServerId=" + gameServerId +
				", dailyRandomTaskReplaceChances=" + dailyRandomTaskReplaceChances +
				", dailyRandomTaskReplaceTime=" + dailyRandomTaskReplaceTime +
				", dailyRandomTaskAcceptChances=" + dailyRandomTaskAcceptChances +
				", dailyRandomTaskAcceptTime=" + dailyRandomTaskAcceptTime +
				", teamId=" + teamId +
				", roomZone='" + roomZone + '\'' +
				", usingHeroId=" + usingHeroId +
				'}';
	}

	public static A mockA() throws IllegalAccessException
	{
		Field[] declaredFields = A.class.getDeclaredFields();
		A a = new A();
		Random random = new Random();
		for(Field field : declaredFields)
		{
			field.setAccessible(true);
			Class<?> type = field.getType();
			if(type == int.class || type == Integer.class)
			{
				field.setInt(a, random.nextInt());
			}
			else if(type == long.class || type == Long.class)
			{
				field.setLong(a, random.nextLong());
			}
			else if(type == double.class || type == Double.class)
			{
				field.setDouble(a, random.nextDouble());
			}
			else if(type == String.class)
			{
				field.set(a, random.nextDouble() + "");
			}
			else if(type == Timestamp.class)
			{
				field.set(a, new Timestamp(System.currentTimeMillis()));
			}
			else if(type == boolean.class || type == Boolean.class)
			{
				field.setBoolean(a, false);
			}
			else
			{
				throw new IllegalArgumentException("not supper " + type);
			}
		}

		return a;
	}

	private static String toParam(String type, String name, int index)
	{
		return String.format("optional %s %s = %d;\n", type, name, index);
	}

	public static String toProto()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("message ASave{\n");
		int index = 1;

		Field[] declaredFields = A.class.getDeclaredFields();
		Random random = new Random();
		for(Field field : declaredFields)
		{
			field.setAccessible(true);
			Class<?> type = field.getType();
			if(type == int.class || type == Integer.class)
			{
				sb.append(toParam("int32", field.getName(), index++));
			}
			else if(type == long.class || type == Long.class)
			{
				sb.append(toParam("int64", field.getName(), index++));
			}
			else if(type == double.class || type == Double.class)
			{
				sb.append(toParam("float", field.getName(), index++));
			}
			else if(type == String.class)
			{
				sb.append(toParam("string", field.getName(), index++));
			}
			else if(type == Timestamp.class)
			{
				sb.append(toParam("int64", field.getName(), index++));
			}
			else if(type == boolean.class || type == Boolean.class)
			{
				sb.append(toParam("bool", field.getName(), index++));
			}
			else
			{
				throw new IllegalArgumentException("not supper " + type);
			}
		}

		sb.append("}");

		return sb.toString();
	}
}
