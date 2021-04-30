# httpServer
Host a local webserver with supporting pictures and webpages.

In the main file you can add pages like this : 

```
Webpage[] pages={new Webpage(path, url)};
Webimage[] images={new Webimage(path, url)};
Webpage error404=new Webpage(path, url);
handler.handle(pages,images,error404);
```

to add more pages you can just add more to the list : 


```
Webpage[] pages={new Webpage(path, url),new Webpage(path, url)};
```
