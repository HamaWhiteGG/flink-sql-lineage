import React,{useState, useEffect} from 'react'
import { Modal, Descriptions, Tabs, message } from 'antd'

const {TabPane} = Tabs
const Cm = (props) => {
  const {functionList, switchVisible, onOk} = props
  const [activeKey, setActiveKey] = useState('')

  const onChange = (key) => {
    console.log(key)
    setActiveKey(key)
  }

  const tabMap = functionList.map((t, i) => {
    return {
      key: t.functionName,
      label: t.functionName,
      children: <Descriptions title="" column={1}>
        {Object.keys(functionList[i]).map(f => <Descriptions.Item label={f}>{functionList[i][f]}</Descriptions.Item>)}
      </Descriptions>
    }
  })

  useEffect(() => {
    functionList.length > 0 && setActiveKey(functionList[0].functionName)
  }, [functionList])

  return (
    <Modal
      {...props}
      title="Preview And Choose"
      onOk={() => {
        onOk({...functionList.filter(t => t.functionName === activeKey)[0]})
        switchVisible(false)
      }}
      onCancel={() => {
        switchVisible(false)
      }}
      okText="apply"
    >
      <Tabs activeKey={activeKey} items={tabMap} onChange={onChange} />
    </Modal>
  )
}
export default Cm