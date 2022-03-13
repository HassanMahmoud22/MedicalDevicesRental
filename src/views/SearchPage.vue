<template>
  <div class="container">

    <div class="menu">
      <h1>{{HospitalName}}</h1>
      <div class="nav_buttons">
        <button >Devices</button>
        <button >Hire staff</button>
        <button >Contact Us</button>
        <button v-on:click="logout">Log Out</button>
      </div>
    </div>


    <div class="search_area">

      <div class="search_bar">
        <span>
          <input type="text" placeholder="i.e. blood pressure digital device" v-model="searchInput">
        </span>
        <button v-on:click="search">Search</button>
      </div>

      <p v-if="displayMsg">{{msg}}</p>

      <div class="filters">
      <!--TODO : add search filters-->
      </div>

      <div class="search_res">
        <ul class="card_list">
          <li class="card" v-for="item in items" :key="item.id">
            <h2>{{item.device_name}}</h2>
            <p>{{item.device_description}}</p>
            <p>{{item.objective}}</p>
            <p>{{item.price}}</p>
            <p>{{item.state}}</p>
            <button>get device</button>
          </li>
        </ul>
      </div>

    </div>


  </div>
</template>

<script>


import axios from "axios";

export default {
  name: "SearchPage",
  components:{
  },
  props:{
    name: String
  },
  data(){
    return({
      HospitalName: "Hospital A",
      searchInput:"",
      items:[],
      msg:'',
    })
  },
  mounted() {
    //TODO: get request to get hospital name
    this.HospitalName = this.name
    this.msg = ''
  },
  methods:{
    search(){
      /*
      amount: 30
      device_description: "measure pressure of blood"
      device_name: "pressure Device"
      id: 1
      objective: "rent"
      price: 15
      state: "new"

       */
      // this.items = [
      //   {
      //     'id': 1523,
      //     'name': 'blood pressure device',
      //     'description': 'a digital device that measures blood pressure',
      //     'rental_price': 10,
      //     'new_price': 3000,
      //     'used_price': 1500,
      //     'amount': 10
      //   },
      //   {
      //     'id': 2625,
      //     'name': 'MRI',
      //     'description': 'Magnetic rays device',
      //     'rental_price': 100000,
      //     'new_price': 700000,
      //     'used_price': 500000,
      //     'amount': 5
      //   },
      //   {
      //     'id': 3251,
      //     'name': 'blood pressure 2 device',
      //     'description': 'a digital device that measures blood pressure',
      //     'rental_price': 10,
      //     'new_price': 3000,
      //     'used_price': 1500,
      //     'amount': 10
      //   },
      //   {
      //     'id': 5262,
      //     'name': 'MRI',
      //     'description': 'Magnetic rays 2 device',
      //     'rental_price': 100000,
      //     'new_price': 700000,
      //     'used_price': 500000,
      //     'amount': 5
      //   }]
      // axios.get('https://medicaldevicesrental.herokuapp.com/api/admin/viewDevices')
      //     .then(response => {
      //       console.log(response.data)
      //       console.log(typeof response.data)
      //       this.items = response.data
      //     })
      // const str = this.searchInput
      // console.log(str)
      // console.log(typeof str)

      this.msg = ''
      const searchJson = {
        "search": this.searchInput
      };

      console.log(searchJson)

      axios.post('https://medicaldevicesrental.herokuapp.com/api/hospital/searchDevice', searchJson,{
        headers: {
          "Access-Control-Allow-Origin": "*",
          "content-Type": "application/json",
        }
      }).then(response => {

            this.items = response.data
            if(this.items.length === 0){
              this.msg = "This device is no longer used. You can try searching for 'blood' instead"
            }

      });


    },
    logout(){
      this.$router.push({name:'Home'})
    },
    displayMsg(){
      return this.msg.length == 0;
    }
  }
}
</script>

<style>

* {
  padding: 0;
  margin: 0;
}

.container{
  width: 100%;
  height: 100%;
  min-height: 720px;
}

.menu {
  background-color: rgba(110, 113, 114,0.6);
  display: flex;
}

.menu .nav_buttons{
}

.menu h1{
  padding: 20px;
  font-size: 40px;
}

.menu .nav_buttons{
}

.menu .nav_buttons button{
  color: #ededed;
  padding: 0px 30px;
  height: 100%;
  background-color: transparent;
  border: none;
  font-size: 20px;
}

.menu .nav_buttons button:hover{
  box-sizing: border-box;
  border-bottom: 5px solid white;
}

.card_list{
  list-style-type: none;
  text-align: left;
}


.card_list li{
  background-color: white;
  margin: 30px;
  padding: 5px;
  background-color: rgba(245, 246, 247, 0.8);
}

.card_list li *{
}


.prices{
  display: table;
  width: 100%;
  table-layout: fixed;
}

.prices span{
  display: table-cell;
  text-align: left;
}

.search_area{
}

.search_bar input{
  width: 50%;
  margin: 40px 10px 0px 15px;
  padding: 10px;
}

.search_bar button{
  width: 15%;
  padding: 10px;
}

</style>

