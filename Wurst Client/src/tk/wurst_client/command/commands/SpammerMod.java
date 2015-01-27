package tk.wurst_client.command.commands;

import tk.wurst_client.Client;
import tk.wurst_client.command.Command;
import tk.wurst_client.module.modules.Spammer;
import tk.wurst_client.utils.MiscUtils;

public class SpammerMod extends Command
{
	private static String[] commandHelp =
	{
		"Changes the delay of Spammer.",
		".spammer delay <delay in ms>"
	};
	
	public SpammerMod()
	{
		super("spammer", commandHelp);
	}
	
	@Override
	public void onEnable(String input, String[] args)
	{
		if
		(
			args == null
			|| args.length < 2
			|| !args[0].toLowerCase().equals("delay")
			|| !MiscUtils.isInteger(args[1])
		)
			commandError();
		else
		{
			int newDelay = Integer.valueOf(args[1]);
			if(newDelay % 50 > 0)
				newDelay = newDelay - newDelay % 50;
			Client.Wurst.options.spamDelay = newDelay;
			Spammer.updateDelaySpinner();
			Client.Wurst.chat.message("Spammer delay set to " + newDelay + "ms.");
		}
	}
}