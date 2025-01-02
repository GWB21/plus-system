import { config } from '@vue/test-utils';
import { RouterLinkStub } from '@vue/test-utils'

config.global.components = {
    RouterLink: RouterLinkStub
}