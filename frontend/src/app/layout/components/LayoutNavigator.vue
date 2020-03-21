<template>
    <div id="nav">
        <Panel v-for="labgroup in settings.labs()" v-bind:key="labgroup.name" :header="labgroup.name">
            <ul>
                <li v-for="lab in labgroup.labs" v-bind:key="lab.name"><router-link :to="lab.route.path">{{ lab.name }}</router-link></li>
            </ul>
        </Panel>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { AppSettings } from '@/app/configs/AppSettings'

@Component
export default class LayoutNavigator extends Vue {
  @Prop() private settings!: AppSettings

  constructor () {
    super()
    this.settings = new AppSettings()
  }
}
</script>

<style scoped lang="scss">
    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        //display: inline-block;
        margin: 0 10px;
    }
</style>
