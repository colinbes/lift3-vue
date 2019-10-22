# Example of using roundtrips with liftweb and vue.
Really nasty and simple example with ideas borrowed from across the web.
Click 'do Round Trip' button to initiate round trip and update page with results.
View ./src/main/client/README.md for client readme

## How it works:
- LiftWeb's snippet code setups/defines roundtrip code and inserts javascript code into global space and is shown in *com.besterdesigns.lib.EmptyRoundTrip*
- Button and insert is handled in RTPage.vue
- *./src/main/webapp/index.html* defines LiftWeb tags and embeds vue index file *./src/main/webapp/dist/index.html*

## Building and running
To build client code change to client directory and execute **npm run build** which will watch for changes and build files to dist folder referenced by LiftWeb

## Creating css files
I used less to manage global scripts. 
On clean install, css files won't exist - to build css files navigate to *./src/main/webapp/assets/css* and execute lessc **../less/mystyles.less mystyles.css**

## Launch LiftWeb

To run liftweb change to root project folder where sbt.build file exists and execute **sbt** and then **jetty:start**

## Comments
- Challenge with this example is workflow - I haven't experimented with how we could use *npm run serve* in development environment and fit in with LiftWeb as first objective was to get roundtrip concept working.

- I also don't like inserting code into global scope and would rather insert in *home.vue's* scope but haven't tried to figure this out yet (actually don't know where to start)