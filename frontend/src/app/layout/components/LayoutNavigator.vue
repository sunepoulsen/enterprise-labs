<template>
    <div id="nav">
        <Panel header="Vue">
            <ul>
                <li><router-link to="/labs/vue/component-rendering">Component Rendering</router-link></li>
            </ul>
        </Panel>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class LayoutNavigator extends Vue {
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
