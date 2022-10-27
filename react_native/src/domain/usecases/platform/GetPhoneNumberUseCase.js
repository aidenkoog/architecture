import PlatformRepository from '../../../data/repositories/platform/PlatformRepository.js'
import Constants from '../../../utils/Constants.js'
import { logDebug } from '../../../utils/Logger.js'


const LOG_TAG = Constants.LOG.COMMON_USECASE_LOG

/**
 * [ usecase naming rule. ]
 * usecase's prefix: execute
 * example. executeConnectDeviceUseCase
 */
const GetPhoneNumberUseCase = () => {

    const { getMyPhoneNumber } = PlatformRepository()

    /**
     * Execute the use case. 
     */
    executeGetPhoneNumberUseCase = () => {
        logDebug(LOG_TAG, ">>> ### triggered executeGetPhoneNumberUseCase")
        getMyPhoneNumber()
    }
    return { executeGetPhoneNumberUseCase }
}

/**
 * export bluetooth usecase.
 */
export default GetPhoneNumberUseCase