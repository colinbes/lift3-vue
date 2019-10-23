<template>
  <div class="roundtrip">
    <h1>{{ msg }}</h1>
    <p>RoundTrip: {{ someValue }}</p>
    <button class="btn btn-default" @click="doSimpleRT()">do Round Trip</button>
  </div>
</template>

<script>

export default {
  name: 'rtPage',
  data () {
    return {
      someValue: 'Click do Round Trip button to see it in action.',
      tstFunction: 'NotDefined'
    }
  },
  props: {
    msg: String
  },
  methods: {
    doSimpleRT () {
      myServices.doSimpleRT().then(response => {
        this.someValue = response
      })
    }
    /*
    If using global injection vs using liftweb's render function to insert js
    doSimpleRT1 () {
      window.vue.$myRTFunctions.doSimpleRT().then(response => {
        this.someValue = response
      })
    }
    */
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
