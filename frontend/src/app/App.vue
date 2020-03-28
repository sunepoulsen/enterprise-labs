<template>
    <div id="app">
        <Layout/>
    </div>
</template>

<script lang="ts">
// @ is an alias to /src
import Layout from '@/app/layout/Layout.vue'
import { Component, Vue } from 'vue-property-decorator'

@Component({
  components: {
    Layout
  }
})
export default class App extends Vue {
}
</script>

<style lang="scss">
    @import '@/assets/styles/global.scss';

    #app {
        font-family: $fontFamily;
        -webkit-font-smoothing: $fontSmoothingWebKit;
        -moz-osx-font-smoothing: $fontSmoothingMoxOsx;
        color: $fontColor;
    }

</style>
