import React,{useState, useEffect} from 'react'
import { useParams, useOutletContext, useLocation } from 'react-router-dom'
import { Descriptions,  Button, Collapse, Tabs, message} from 'antd'
import io from '@common/io-context'
import OverView from './function-info-overview'
import Audit from './function-info-audit'
import ModalAddFunction from './modal-add-function'

const Cm = () => {
  const {title} = useLocation().state
  const {id: catalogId, itemId: functionId} = useParams()
  const { catalogDetail, databaseName, itemId } = useOutletContext()
  const [activeKey, setActiveKey] = useState('1')
  const [addFunVisible, setAddFunVisible] = useState(false)
  const [applyFunVisible, setApplyFunVisible] = useState(false)
  const [curDatabase, setCurDatabase] = useState(databaseName)
  const [formValues, setFormValues] = useState({})
  const [functionList, setFunctionList] = useState([])
  const [refresh, setRefresh] = useState(0)
  const { catalogName, catalogType, defaultDatabase, pluginId, pluginName } = catalogDetail

  const onChange = (key) => {
    setActiveKey(key)
  }

  const getFunInfos = async id => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/functions/${id || functionId}`)
      setFormValues({...res})
    } catch (error) {
      message.error(error)
    }
  }

  const infoProps = {
    catalogId,
    defaultDatabase,
    functionId,
    databaseName,
    refresh,
  }

  const items = [
    {
      key: '1',
      label: `Overview`,
      children: <OverView {...infoProps} />,
    },
    {
      key: 'audit',
      label: `Audit`,
      children: <Audit {...infoProps} />,
    },
  ]

  const ModalAddFunProps = {
    type: 'edit',
    visible: addFunVisible,
    curDatabase,
    databaseList: [],
    formValues,
    catalogDetail,
    getDetail: () => setRefresh(refresh + 1),
    switchVisible: setAddFunVisible,
    analysisCallback: params => {
      setFunctionList(params.functionList)
    },
    switchApplyFunVisible: setApplyFunVisible,
  }

  useEffect(() => {
    setActiveKey('1')
  }, [databaseName, itemId])
  
  return (
    <div className='right-info-box'>
      <div className='white-bg p16'>
        <Descriptions title={title} extra={<Button type="primary" onClick={() => {
          getFunInfos()
          setAddFunVisible(true)
        }}>Edit</Button>}>
          <Descriptions.Item label="Name">{catalogName}</Descriptions.Item>
          <Descriptions.Item label="Type">{catalogType}</Descriptions.Item>
          <Descriptions.Item label="Database">{defaultDatabase}</Descriptions.Item>
          <Descriptions.Item label="Plugin">{pluginName}</Descriptions.Item>
        </Descriptions>
      </div>
      <Tabs className='gray-bg' tabBarStyle={{background: '#fff', paddingLeft: '16px', paddingRight: '16px'}} activeKey={activeKey} items={items} onChange={onChange} />
      <ModalAddFunction {...ModalAddFunProps} />
    </div>
  )
}
export default Cm