from bs4 import BeautifulSoup
import requests
url= input("pleases enter amazon url: ")

custom_headers={
    'user-agent' :'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:120.0) Gecko/20100101 Firefox/120.',
    'Accept-Language':'en-US,en;q=0.5'
}

response = requests.get(url, headers=custom_headers)

soup = BeautifulSoup(response.text, 'lxml')

title_element = soup.select_one('#productTitle')
title = title_element.text.strip()

price_element = soup.select_one('#price_inside_buybox')
print(price_element.text)