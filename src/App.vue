<template>
  <!--<a href='https://www.freepik.com/vectors/banner'>Banner vector created by starline - www.freepik.com</a>-->
  <router-view/>
</template>

<script>
export default {
  name: "App",
  data(){
    return({
      input: {
        username: "user",
        pw: "pw"
      }
    })
  }
}
</script>

<style>

*{
  padding: 0px;
  margin: 0px;
}

p{
  margin: 30px;
  padding: 10px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-image: url('assets/background.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
  margin: 0px;
  padding: 0px;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
