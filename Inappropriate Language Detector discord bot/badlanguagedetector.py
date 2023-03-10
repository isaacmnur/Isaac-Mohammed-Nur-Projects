# This is a code for a discord bot that checks for inappropriate language in a server
# If it detects inappropriate language then it will delete the message write a warning message

import discord
from better_profanity import profanity

# Sends message to channel in server
async def send_message(message, user_message):
    try:
        await message.channel.send(user_message)
    except Exception as e:
        print(e)

def run_discord_bot():
    
    TOKEN = # use personal discord bot token here
    client = discord.Client(intents=discord.Intents.all())

    # Prints when bot is online
    @client.event
    async def on_ready():
        print(f'{client.user} is now running!')

    # when a message is typed it will do this function 
    @client.event
    async def on_message(message):
        # checks if the bot typed the message
        if message.author == client.user:
            return
        # gets user message then censors the inappropriate language
        user_message = str(message.content)
        censored = profanity.censor(user_message)

        # deletes message if contains inappropriate language then sends message
        for element in censored:
            if element == '*':
                await message.channel.purge(limit=1)
                await send_message(message, 'That language is not allowed in this server.')
                break
    client.run(TOKEN)

if __name__ == '__main__':
    run_discord_bot()
